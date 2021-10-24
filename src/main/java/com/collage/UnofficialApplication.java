package com.collage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;




@SpringBootApplication
@PropertySource(value={"classpath:messages.properties"})

public class UnofficialApplication {


	public static void main(String[] args) {
		SpringApplication.run(UnofficialApplication.class, args);
		System.out.println("WELCOMEEEEEE");
	}

}
