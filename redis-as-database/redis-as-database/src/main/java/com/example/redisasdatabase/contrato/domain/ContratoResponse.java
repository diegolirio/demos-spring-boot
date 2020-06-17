package com.example.redisasdatabase.contrato.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("contratos")
public class ContratoResponse {

    @Id
    private String codigo;
    private List<Summary> summary;    
    private Message message;
    private Jornada jornada;
    private List<Contrato> contratos;

    
}