package com.example.codedefault.contratos.mapper;

import java.util.List;

import com.example.codedefault.contratos.integration.al0ipdc.Al0iPDCEntrada;
import com.example.codedefault.contratos.integration.av2.ClienteAv2;
import com.example.codedefault.contratos.integration.av2.ContratoAv2;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Al0iPDCMapper {

    Al0iPDCMapper MAPPERS = Mappers.getMapper(Al0iPDCMapper.class);

	Al0iPDCEntrada toAl0iPDCEntrada(ClienteAv2 clienteAv2, List<ContratoAv2> contratosAv2);

}
