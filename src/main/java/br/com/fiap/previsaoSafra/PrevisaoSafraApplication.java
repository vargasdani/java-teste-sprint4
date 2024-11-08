package br.com.fiap.previsaoSafra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class PrevisaoSafraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrevisaoSafraApplication.class, args);
	}

}
