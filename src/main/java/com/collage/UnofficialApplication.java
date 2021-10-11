package com.collage;

import com.collage.entity.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@PropertySource(value={"classpath:messages.properties"})

public class UnofficialApplication {


	public static void main(String[] args) {
		SpringApplication.run(UnofficialApplication.class, args);
		System.out.println("WELCOMEEEEEE");
	}

}
