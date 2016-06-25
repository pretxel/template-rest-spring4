package com.rest.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.models.Greeting;

@Service
public class GreetingService {
	private static final String template = "Hello, %s!";
	
	@Autowired
	private Greeting greeting;
	
	public Greeting greetingNow(AtomicLong counter, String name){
		greeting.setId(counter.incrementAndGet());
		greeting.setContent(String.format(template, name));
		return greeting;
	}
	
	
	public Greeting grettingAdd(){
		greeting.setId(0);
		greeting.setContent("Added");
		return greeting;
	}
}
