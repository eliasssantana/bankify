package com.cashable.bankify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bankify", version = "1", description = "API RESTful da aplicação Bankify"))
public class BankifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankifyApplication.class, args);
	}

}
