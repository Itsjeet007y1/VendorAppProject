package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	public String getCommonString(int length){
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0,length).toUpperCase();
	}
	public String getPassword(){
		return getCommonString(8);
	}
	public String getTocken(){
		return getCommonString(6);
	}
}
