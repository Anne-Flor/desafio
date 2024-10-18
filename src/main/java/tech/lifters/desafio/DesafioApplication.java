package tech.lifters.desafio;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

import jakarta.ws.rs.ApplicationPath;

@SpringBootApplication
@ApplicationPath("/desafio")
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
