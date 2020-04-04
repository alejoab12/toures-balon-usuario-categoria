package com.toures.balon;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableDiscoveryClient(autoRegister = false)
@SpringBootApplication
@ComponentScan(basePackages = { "com.toures.balon", "com.commons.gema" })
public class TouresBalonUsuarioCategoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouresBalonUsuarioCategoriaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
