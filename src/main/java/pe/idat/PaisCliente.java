package pe.idat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soapws.wsdl.*;



public class PaisCliente extends WebServiceGatewaySupport {
	
	private static final Logger log = LoggerFactory.getLogger(PaisCliente.class);
	
	public GetPaisResponse getPais(String pais) {
		GetPaisRequest request = new GetPaisRequest();
		request.setNombre(pais);
		log.info("Solicitando datos de:" + pais);
		GetPaisResponse response = (GetPaisResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8093/ws/paises", request, 
				new SoapActionCallback("http://idat.pe/ws/GetPaisRequest"));
		return response;
	}

	public GetPaisesResponse getPaises() {
		GetPaisesRequest request = new GetPaisesRequest();
		log.info("Solicitando datos de todos los paises");
		GetPaisesResponse response = (GetPaisesResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8093/ws/paises", request, 
				new SoapActionCallback("http://idat.pe/ws/getPaisesRequest"));
		return response;
	}

}
