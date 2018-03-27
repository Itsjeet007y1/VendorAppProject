package com.app.test;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonToObjectTest {
	public static void main(String[] args) {
		String json="{\"eid\":101,\"ename\":\"Jitendra\",\"esal\":36.63}";
		//create the object of object mapper class
		ObjectMapper om=new ObjectMapper();
		try {
			Employee emp=om.readValue(json, Employee.class);
			System.out.println(emp);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
