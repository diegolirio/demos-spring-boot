package com.example.codedefault.contratos.facade;

import java.util.List;

import com.example.codedefault.contratos.integration.bre.BreContratoValidoSaida;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContratoSaidaMapper {

    ContratoSaidaMapper MAPPERS = Mappers.getMapper(ContratoSaidaMapper.class);

    ContratoResponse map(BreContratoValidoSaida breContratoValidoSaida);

	List<ContratoResponse> map(List<BreContratoValidoSaida> listBreContratoValidoSaida);

}
