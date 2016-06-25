package com.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.models.Greeting;
import com.rest.services.GreetingService;

@RestController
@RequestMapping("/api")
public class GreetingController {

	private static final Logger logger = 
			LoggerFactory.getLogger(GreetingController.class);
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private GreetingService greetingService;

    @RequestMapping(method=RequestMethod.GET, value="/")
    public String hello() {
    	logger.debug("getWelcome is executed!");
    	return "API";
    }
    
    
    @RequestMapping(method=RequestMethod.GET, value="/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	return greetingService.greetingNow(counter, name);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/greeting")
    public Greeting greetingAdd(@RequestBody Greeting greeting) {
    	System.out.println(greeting.getId());
    	GreetingService greetingService = new GreetingService();
        return greetingService.grettingAdd();
    }
}
