package io.github.diegolirio.demousermicroservice.email;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "emailService", url = "http://localhost:8085", fallback = EmailFallback.class)
public interface EmailService {
	 @PostMapping("/v1/api/emails")
	 void send(@RequestBody EmailDTO emailDTO);
}
