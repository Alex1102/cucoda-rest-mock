package service.rest.cucoda.customer.boundary;

import com.mycompany.cucodamock.backdoor.CucodaResponse;
import com.mycompany.cucodamock.backdoor.storage.StaticStorage;
import com.mycompany.service.rest.cucoda.customer.boundary.CucodaCustomerService;

import javax.ws.rs.core.Response;

public class CucodaCustomerBoundary implements CucodaCustomerService {

	@Override
	public Response addCustomer(String customerId) {
		var response = StaticStorage.CUSTOMER_ADD_RESPONSE.get(customerId);
		return toJaxRsResponse(response);
	}

	@Override
	public Response deleteCustomer(String customerId) {
		var response = StaticStorage.CUSTOMER_DELETE_RESPONSE.get(customerId);
		return toJaxRsResponse(response);
	}

	private Response toJaxRsResponse(CucodaResponse mockResponse){
		Response.ResponseBuilder responseBuilder = Response.status(mockResponse.getStatus());
		mockResponse.getHeaders().forEach(responseBuilder::header);
		return responseBuilder.build();
	}
}
