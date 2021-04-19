package com.publicis.sapient.project.publicissapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PublicisSapientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicisSapientApplication.class, args);
	}

}
