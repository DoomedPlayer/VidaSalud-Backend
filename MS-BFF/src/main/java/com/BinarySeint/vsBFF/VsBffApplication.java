package com.BinarySeint.vsBFF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients 
public class VsBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(VsBffApplication.class, args);
	}

}
