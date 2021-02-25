package com.mycompany.service.rest.cucoda.customer.boundary;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(CucodaCustomerService.BASE_PATH)
public interface CucodaCustomerService {

	String BASE_PATH = "customers";

	@POST
	@Path("{customerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	Response addCustomer(@PathParam("customerId") String customerId);

	@DELETE
	@Path("{customerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	Response deleteCustomer(@PathParam("customerId") String customerId);
}
