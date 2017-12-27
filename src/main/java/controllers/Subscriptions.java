package controllers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Subscriptions extends MongoRepository<Subscriber, String>{

	public Subscriber findByName(String name);
	public Subscriber findByEmail(String email);
	
}
