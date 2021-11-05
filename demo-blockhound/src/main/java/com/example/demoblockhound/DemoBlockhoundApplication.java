package com.example.demoblockhound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class DemoBlockhoundApplication {

	static {
		BlockHound.install();
//		BlockHound.install(builder -> builder.allowBlockingCallsInside("BoundedElasticScheduler$BoundedState", "dispose"));

	}

	public static void main(String[] args) {

		//BlockHound.install();

		SpringApplication.run(DemoBlockhoundApplication.class, args);
	}

}
