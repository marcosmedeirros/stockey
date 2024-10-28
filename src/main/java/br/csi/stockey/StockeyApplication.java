package br.csi.stockey;

import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Models.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockeyApplication {

	public static void main(String[] args) {
		SpringApplication. run(StockeyApplication.class, args);
	}


}
