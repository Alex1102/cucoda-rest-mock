package com.mycompany.cucodamock.backdoor.boundary;

import com.mycompany.cucodamock.backdoor.BackdoorService;
import com.mycompany.cucodamock.backdoor.CucodaResponse;
import com.mycompany.cucodamock.backdoor.storage.StaticStorage;

public class BackdoorServiceBoundary implements BackdoorService {

	@Override
	public void addCustomer(String customerId, CucodaResponse response) {
		StaticStorage.CUSTOMER_ADD_RESPONSE.put(customerId, response);
	}

	@Override
	public void deleteCustomer(String customerId, CucodaResponse response) {
		StaticStorage.CUSTOMER_DELETE_RESPONSE.put(customerId, response);
	}

}
