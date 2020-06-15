package io.github.diegolirio.demousermicroservice.email;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {

	private String from;
	private List<String> to;
	private List<String> cc;
	private List<String> co;
	private String subject;
	private String message;
		
}
