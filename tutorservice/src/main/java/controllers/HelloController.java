package controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class HelloController {

	@Autowired
	private Subscriptions subscriptions;

	@GetMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}

//	@RequestMapping({"/hello2", "/static/about.html"})
//	public String hello2() {
//
//		return "about";
//	}

	@PostMapping("/hello4")
	public String hello3(@ModelAttribute Subscriber subscriber) {
		String name = subscriber.getName();
		String email = subscriber.getEmail();
		
		System.out.println("Name: " + name + " Email: " + email);

//		subscriptions.deleteAll();
//
//		// save a couple of customers
//		subscriptions.save(new Subscriber(name, email));

		return "about";
	}

}
