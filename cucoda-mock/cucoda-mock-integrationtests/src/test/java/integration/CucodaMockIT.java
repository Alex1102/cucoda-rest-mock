package integration;

import static javax.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.BDDAssertions.then;

import com.mycompany.cucodamock.backdoor.BackdoorService;
import com.mycompany.cucodamock.backdoor.CucodaResponse;
import com.mycompany.service.rest.cucoda.customer.boundary.CucodaCustomerService;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.core.Response;

import cocoda.ServiceLocator;

import org.junit.jupiter.api.Test;


public class CucodaMockIT {

	private static final Random RANDOM = new Random();

	private static final String BASE_PATH = "http://localhost:8080/cucoda-rest-mock/";
	private final BackdoorService backdoorService = new ServiceLocator<>(BackdoorService.class, BASE_PATH).build();
	private final CucodaCustomerService cucodaCustomerService = new ServiceLocator<>(CucodaCustomerService.class, BASE_PATH).build();

	@Test
	void addCustomer_success() {
		String customerId = String.valueOf(RANDOM.nextInt());
		backdoorService.addCustomer(customerId, new CucodaResponse(OK, Map.of("test", "added")));

		Response response = cucodaCustomerService.addCustomer(customerId);

		then(response.getStatus()).isEqualTo(OK.getStatusCode());
		then(response.getHeaders()).containsEntry("test", List.of("added"));
	}

}
