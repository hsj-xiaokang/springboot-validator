package com.hsj.hsjValidTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.hsjValidTest.testPojo.Person;



@SpringBootApplication
@RestController
@RequestMapping(value = "/app")
public class App{
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	    @RequestMapping(value = "/test", method=RequestMethod.GET)
	    public Object test() throws Exception {            
	        return new Person(18,"hsj");
	    }
}
