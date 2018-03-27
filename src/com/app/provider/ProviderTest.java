package com.app.provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Path("/msg")
@Component
public class ProviderTest {
	@GET
	@Path("/show")
	public String showMessage(){
		return "Hello";
	}
}
