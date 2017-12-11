package controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import database.Student;

@SpringBootApplication
public class App {
	
	@Autowired
	private StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    
//    @Override
//	public void run(String... args) throws Exception {
//
//		repository.deleteAll();
//
//		// save a couple of customers
//		repository.save(new Student("Alice", "Smith", "Alice@gmail.com", "333-333-3333"));
//		repository.save(new Student("Bob", "Smith", "Bob@gmail.com", "444-444-4444"));
//
//		// fetch all customers
//		System.out.println("Students found with findAll():");
//		System.out.println("-------------------------------");
//		for (Student customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Student customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
//
//	}

}
