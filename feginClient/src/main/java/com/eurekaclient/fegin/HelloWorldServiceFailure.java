package com.eurekaclient.fegin;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class HelloWorldServiceFailure implements FallbackFactory<Client> {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldServiceFailure.class);

	@Override
	public Client create(Throwable throwable) {
		return new Client() {
			@Override
			public String getName(String name) {
				log.info("fegin调用异常："+throwable);
				return "fegin调用返回异常："+throwable;
			}
		};
	}
}

