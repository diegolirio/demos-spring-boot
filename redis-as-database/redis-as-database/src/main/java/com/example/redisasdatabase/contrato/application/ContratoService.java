package com.example.redisasdatabase.contrato.application;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.example.redisasdatabase.contrato.domain.Contrato;
import com.example.redisasdatabase.contrato.domain.ContratoResponse;
import com.example.redisasdatabase.contrato.domain.Jornada;
import com.example.redisasdatabase.contrato.domain.Message;
import com.example.redisasdatabase.contrato.domain.Summary;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratoService {

	private final ContratoRepository repository;

    public ContratoResponse getByCpfCnpj(final String cpfCnpj, final String codigo) {
        Optional<ContratoResponse> buscaNoRedis = this.getCodigo(codigo);
        if(codigo != null && buscaNoRedis.isPresent()) {
            return buscaNoRedis.get();
        }

        Map<String, Double> hashMap = new HashMap<>();
        hashMap.put("amount", 0.0D);

        Summary summary = Summary.builder()
                                .field("valor")
                                .value(hashMap)
                                .build();

        Contrato contrato = Contrato.builder()
                                    .codigo("95622")
                                    .idContrato("6526252")
                                    .valor(1520.99D)
                                    .build();

        final ContratoResponse response = new ContratoResponse();
        response.setCodigo(UUID.randomUUID().toString());
        response.setSummary(List.of(summary));
        response.setMessage(Message.builder().codigo("success").mesangem("OK").build());
        response.setJornada(new Jornada(555L, LocalDateTime.now()));
        response.setContratos(List.of(contrato));

        return this.repository.save(response);
	}

    private Optional<ContratoResponse> getCodigo(String codigo) {
        if(StringUtils.isEmpty(codigo)) {
            return Optional.empty();
        }
        return repository.findById(codigo);
    }

}
