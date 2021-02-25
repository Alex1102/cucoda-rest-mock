package com.mycompany.cucodamock.backdoor.storage;

import com.mycompany.cucodamock.backdoor.CucodaResponse;

public class StaticStorage {

	public static final GenericStorage<String, CucodaResponse> CUSTOMER_ADD_RESPONSE = new GenericStorage<>();
	public static final GenericStorage<String, CucodaResponse> CUSTOMER_DELETE_RESPONSE = new GenericStorage<>();
}
