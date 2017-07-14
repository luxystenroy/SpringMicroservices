package com.example.hateoas;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
    
    private Environment env;
	
	@Autowired
	GreetingController(Environment env){
		this.env = env;
	}

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        
        logger.info("bootrest.customproperty "+
        		env.getProperty("bootrest.customproperty"));

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}