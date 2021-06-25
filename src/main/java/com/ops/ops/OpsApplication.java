package com.ops.ops;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsApplication.class, args);
	}

}
