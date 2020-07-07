package com.example.codedefault.contratos.facade;

import java.util.List;
import java.util.stream.Collectors;

import com.example.codedefault.config.RxJavaCommon;
import com.example.codedefault.contratos.dominio.Contrato;
import com.example.codedefault.contratos.integration.ak3.Ak3Service;
import com.example.codedefault.contratos.integration.ak3.ContratoAk2Saida;
import com.example.codedefault.contratos.integration.al0ipdc.Al0iPDCEntrada;
import com.example.codedefault.contratos.integration.al0ipdc.Al0iPDCSaida;
import com.example.codedefault.contratos.integration.al0ipdc.Al0iPDCService;
import com.example.codedefault.contratos.integration.av2.Av2Service;
import com.example.codedefault.contratos.integration.av2.ClienteAv2;
import com.example.codedefault.contratos.integration.av2.ContratoAv2;
import com.example.codedefault.contratos.integration.bre.BreContratoValidoEntrada;
import com.example.codedefault.contratos.integration.bre.BreContratoValidoSaida;
import com.example.codedefault.contratos.integration.bre.BreService;
import com.example.codedefault.contratos.mapper.Al0iPDCMapper;
import com.example.codedefault.contratos.mapper.BREContratoValidoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rx.Observable;

@Component
public class ContratoFacade implements RxJavaCommon {

	@Autowired
	private Av2Service av2Service;

	@Autowired
	private Al0iPDCService al0iPDCService;

	@Autowired
	private Ak3Service ak3Service;

	@Autowired
	private BreService breService;

	public List<ContratoResponse> getContratos(final String cpfCnpj) {

		final Observable<List<ContratoAv2>> contratosAv2Obs = 
			getObservableParallel().map(s -> this.av2Service.getContratos(cpfCnpj));

		Observable<ClienteAv2> clienteAv2Obs = 
			getObservableParallel().map(s -> this.av2Service.getSegmentacao(cpfCnpj));

		Agregator agregator = Observable.zip(contratosAv2Obs, clienteAv2Obs, (contratos, segmentacao) -> {
			return new Agregator(contratos, segmentacao);
		}).toBlocking().single();

		Al0iPDCEntrada al0iPDCEntrada = Al0iPDCMapper.MAPPERS.toAl0iPDCEntrada(agregator.getClienteAv2(), agregator.getContratosAv2());
		Al0iPDCSaida al0iPDCSaida = this.al0iPDCService.getContratos(al0iPDCEntrada);

		List<Observable<ContratoAk2Saida>> contratosAk3Obs =
		 agregator.getContratosAv2()
		 		  .stream()
		 		  .map(contrato -> getObservableParallel().map(m -> this.ak3Service.getPromessas(contrato)))
				  .collect(Collectors.toList());

		List<ContratoAk2Saida> contratosAk3 = null;

		List<BreContratoValidoEntrada> listBreEntrada = 
			BREContratoValidoMapper.MAPPERS.map(contratosAk3, al0iPDCSaida, agregator.getClienteAv2(), agregator.getContratosAv2());

		List<Observable<BreContratoValidoSaida>> breListObs = 
				listBreEntrada.stream()
				   			  .map(contrato -> getObservableParallel().map(m -> this.breService.getContratosValidos(contrato)))
							  .collect(Collectors.toList());

		List<BreContratoValidoSaida> listBreContratoValidoSaida = Observable.from(breListObs).flatMap(e -> e).toList().toBlocking().single();

		List<ContratoResponse> contratos = ContratoSaidaMapper.MAPPERS.map(listBreContratoValidoSaida);
		return contratos;
	}

}
