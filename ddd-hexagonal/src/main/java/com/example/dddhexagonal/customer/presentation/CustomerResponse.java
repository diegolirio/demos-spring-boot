package com.example.dddhexagonal.customer.presentation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

    private String firstname;
    private String lastname;

}
