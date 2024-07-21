package io.github.weidmann16.segurosbolivar.app;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.weidmann16.segurosbolivar.app.application.service.RickAndMortyService;


@SpringBootApplication
@RequiredArgsConstructor
public class SegurosBolivarServiceApplication implements CommandLineRunner {

	private final RickAndMortyService rickAndMortyService;

	public static void main(String[] args) {
		SpringApplication.run(SegurosBolivarServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rickAndMortyService.fetchAndSaveData();
	}

}

