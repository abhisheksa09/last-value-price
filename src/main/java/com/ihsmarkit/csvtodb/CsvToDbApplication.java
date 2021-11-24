package com.ihsmarkit.csvtodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CsvToDbApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CsvToDbApplication.class, args);
	}

}
