package com.eurekaclient.fegin;

import org.springframework.stereotype.Component;


@Component
public class HelloWorldServiceFailure implements Client {

	@Override
	public String getName(String name) {
		System.out.println("hello world service is not available !");
		return "hello world service is not available !";
	}

}
