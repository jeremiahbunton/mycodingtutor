package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

//	@Autowired
//	private Subscriptions subscriptions;

	@GetMapping("/hello2")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping({"/hello3", "/static/about.html"})
	public String hello2() {

		return "about this";
	}

	@PostMapping("/hello")
	public Subscriber hello3(@ModelAttribute Subscriber subscriber) {
		String name = subscriber.getName();
		String email = subscriber.getEmail();
		
		System.out.println("Name: " + name + " Email: " + email);

//		subscriptions.deleteAll();
//
//		// save a couple of customers
//		subscriptions.save(new Subscriber(name, email));

		return subscriber;
	}

}
