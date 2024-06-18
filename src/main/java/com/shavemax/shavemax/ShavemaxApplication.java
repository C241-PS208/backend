package com.shavemax.shavemax;

import com.shavemax.shavemax.entity.Role;
import com.shavemax.shavemax.enums.RoleEnum;
import com.shavemax.shavemax.repository.RoleRepository;
import com.shavemax.shavemax.service.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.shavemax.*")
@ComponentScan(basePackages = "com.shavemax.shavemax.*")
@ConfigurationPropertiesScan(basePackages = {"com.shavemax.shavemax.config"})

public class ShavemaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShavemaxApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run(AuthService authService) {
		return args -> {
			authService.starter();
		};
	}

}
