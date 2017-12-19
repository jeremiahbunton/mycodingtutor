package controllers;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

import database.ContactForm;
import database.Student;
//import hello.Greeting;

@Controller
public class GreetingController {


	//	@RequestMapping("/greeting")
	//	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	//		model.addAttribute("name", name);
	//		return "greeting";
	//	}

	@GetMapping("/about")
	public String greeting2(Model model) {
		model.addAttribute("subscriber", new Subscriber());
		return "about";
	}

	@PostMapping("/about")
	public String greeting1(@ModelAttribute Subscriber subscriber, Model model) {
		System.out.println(subscriber.getEmail());
		System.out.println(subscriber.getName());
		sendEmail(subscriber.getName(), subscriber.getEmail(), "Test", "This is a test222");
		model.addAttribute("subscriber", new Subscriber());
		return "about";
	}

	@GetMapping("/home")
	public String index(Model model) {
		model.addAttribute("subscriber", new Subscriber());
		return "index";
	}

	@PostMapping("/home")
	public String indexSubmit(@ModelAttribute Subscriber subscriber, Model model) {
		System.out.println(subscriber.getEmail());
		System.out.println(subscriber.getName());
		sendEmail(subscriber.getName(), subscriber.getEmail(), "Test", "This is a test222");
		model.addAttribute("subscriber", new Subscriber());
		return "index";
	}

	@GetMapping("/services")
	public String getServices(Model model) {
		model.addAttribute("subscriber", new Subscriber());
		return "services";
	}
	@PostMapping("/services")
	public String servicesSubmit(@ModelAttribute Subscriber subscriber, Model model) {
		model.addAttribute("subscriber", new Subscriber());
//		sendEmail(contactform.getName(), contactform.getEmail(), contactform.getSubject(), contactform.getMessage());
		return "services";

	}

	@GetMapping("/contact")
	public String getContact(Model model) {
		model.addAttribute("contactform", new ContactForm());
		model.addAttribute("subscriber", new Subscriber());
		return "contact";
	}

	@PostMapping("/contact")
	public String contactUsSubmit(@ModelAttribute ContactForm contactform, Subscriber subscriber, Model model) {
		System.out.println(contactform.getMessage());
		model.addAttribute("contactform", new ContactForm());
		model.addAttribute("subscriber", new Subscriber());
//		sendEmail(contactform.getName(), contactform.getEmail(), contactform.getSubject(), contactform.getMessage());
		return "contact";

	}
	
	@RequestMapping("/")
	public String catchAll(Model model) {
		model.addAttribute("subscriber", new Subscriber());
		return "index";
	}

	private void sendEmail(String name, String email, String subject, String body) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jeremiahbunton","Surferdude10");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("jeremiah.bunton@gmail.com"));
			message.setSubject(email);

			StringBuilder builder = new StringBuilder();
			builder.append("Name: " + name);
			builder.append(System.lineSeparator());
			builder.append(System.lineSeparator());
			builder.append("Email: " + email);
			builder.append(System.lineSeparator());
			builder.append(System.lineSeparator());
			builder.append("Subject: " + subject);
			builder.append(System.lineSeparator());
			builder.append(System.lineSeparator());
			builder.append("Message: " + message);
			message.setText(body);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
	}
}

