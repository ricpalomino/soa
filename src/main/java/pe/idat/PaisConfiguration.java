package pe.idat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PaisConfiguration {

    @Bean
    Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.soapws.wsdl");
		return marshaller;
	}

    @Bean
    PaisCliente paisCliente(Jaxb2Marshaller marshaller) {
		PaisCliente cliente = new PaisCliente();
		cliente.setDefaultUri("http://localhost:8093/ws/");
		cliente.setMarshaller(marshaller);
		cliente.setUnmarshaller(marshaller);
		return cliente;
	}

}
