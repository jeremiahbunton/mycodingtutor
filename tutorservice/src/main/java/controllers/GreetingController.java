package controllers;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import database.Student;

@RestController
public class GreetingController {

	
//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}

	@GetMapping("/greeting2")
	public String greeting2(Model model) {
//		return "{\"message\":\"Hello world\"";
		
		return "Hello";
	}
	
	@PostMapping(value = "/greeting1", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String greeting1(@RequestParam Map<String, String> user) {
		System.out.println(user.get("email"));
		System.out.println(user.get("name"));
		return "hello";
	}
}
