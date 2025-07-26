package com.mxs2.api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CrudCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudCarrosApplication.class, args);
	}
}