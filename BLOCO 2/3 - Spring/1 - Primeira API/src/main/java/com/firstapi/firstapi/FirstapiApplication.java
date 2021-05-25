package com.firstapi.firstapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController 
public class FirstapiApplication {

	@GetMapping ("/")
	public String softskills () {
		return " Olá Mundo! A seguir vocês verão quais mentalidades e habilidades eu utilizei para a criação dessa aplicação!"
				+ "Mentalidades: "
				+ "♥ Persistência "
				+ "♥ Mentalidade de crescimento "
				+ "♥ Responsabilidade. "
				+ "Habilidades: "
				+ "♥ Atenção aos detalhes "
				+ "♥ Proatividade "
				+ "♥ Comunicação ";
	}
	@GetMapping ("/exercicio2")
	public String maoe () {
		return "Meus objetivos de aprendizagem para a semana são: "
				+ "♥ Conseguir absorver todo o conteúdo sobre framework que for passado "
				+ "♥ Continuar com fome, continuar boba! ";	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FirstapiApplication.class, args);
		
	}

}
