package com.example.demospringbootgraphql.controller.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CustodyResponse(String id, String customerId, BigDecimal purchaseValue, ProductResponse product, LocalDateTime createdAt) {
}