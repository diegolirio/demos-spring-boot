package com.diegolirio.demospringdataspecifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	
    private String key;
    private String operation;
    private Object value;
}
