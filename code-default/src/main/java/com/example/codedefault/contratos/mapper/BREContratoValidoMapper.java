package com.example.codedefault.contratos.mapper;

import java.util.List;

import com.example.codedefault.contratos.integration.ak3.ContratoAk2Saida;
import com.example.codedefault.contratos.integration.al0ipdc.Al0iPDCSaida;
import com.example.codedefault.contratos.integration.av2.ClienteAv2;
import com.example.codedefault.contratos.integration.av2.ContratoAv2;
import com.example.codedefault.contratos.integration.bre.BreContratoValidoEntrada;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BREContratoValidoMapper {


    BREContratoValidoMapper MAPPERS = Mappers.getMapper(BREContratoValidoMapper.class);

    List<BreContratoValidoEntrada> map(List<ContratoAk2Saida> contratosAk3, 
                                       Al0iPDCSaida al0iPDCSaida,
			                           ClienteAv2 clienteAv2, List<ContratoAv2> contratosAv2);


}
