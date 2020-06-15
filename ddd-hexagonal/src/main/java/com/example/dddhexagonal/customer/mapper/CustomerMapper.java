package com.example.dddhexagonal.customer.mapper;

import com.example.dddhexagonal.customer.domain.Customer;
import com.example.dddhexagonal.customer.presentation.CustomerResponse;
import com.example.dddhexagonal.customer.presentation.CustomerResponseID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * More: https://gitlab.com/uati/esb-crc/-/blob/master/src/main/java/br/com/itau/crc/esbcrc/v1/contrato/mapper/ContratoMapper.java
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseID toMapResponseID(Customer customer);

    CustomerResponse toMapResponse(Customer customer);

    List<CustomerResponse> toMapList(List<Customer> customers);

}
