package pe.idat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.soapws.wsdl.*;

@SpringBootApplication
public class SoapclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapclientApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(PaisCliente paisCliente) {
		return args -> {
			// obtienes lista de paises
			GetPaisesResponse paisesResponse = paisCliente.getPaises();
			for (Pais pais : paisesResponse.getPaises()) {
				System.err.println("Pais : " +  pais.getNombre());
			}
			//busca un pais por nombre
			String pais = "Ecuador";
			if (args.length > 0) {
				pais = args[0];
			}
			GetPaisResponse response = paisCliente.getPais(pais);
			System.err.println("Capital : " +  response.getPais().getCapital());
			System.err.println("Moneda : " +  response.getPais().getMoneda());
			System.err.println("Poblacion : " +  response.getPais().getPoblacion());
		};
	}

}
