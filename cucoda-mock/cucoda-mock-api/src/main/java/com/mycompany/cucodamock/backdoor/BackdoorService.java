package com.mycompany.cucodamock.backdoor;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path(BackdoorService.BASE_PATH)
public interface BackdoorService {

	String BASE_PATH = "backdoor/customers";

	@POST
	@Path("{customerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	void addCustomer(@PathParam("customerId") String customerId, CucodaResponse response);

	@DELETE
	@Path("{customerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	void deleteCustomer(@PathParam("customerId") String customerId, CucodaResponse response);

}
