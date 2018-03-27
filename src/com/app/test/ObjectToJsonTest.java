package com.app.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ObjectToJsonTest {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException {
		//create the object of employee class and set the values
		Employee emp=new Employee()	;
		emp.setEid(101);
		emp.setEname("Jitendra");
		emp.setEsal(36.63);
		//create the object of Object mapper
		ObjectMapper om=new ObjectMapper();
		try {
			String json=om.writeValueAsString(emp);
			System.out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
