package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroblogSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroblogSpringApplication.class, args);
	}
}



//		In home.html, use Mustache tags to conditionally show the markup in the two screenshots below
//		If username doesn't exist, show the login form like the first screenshot
//		If username does exist, show the message submission form and message list like the second screenshot
//		It should take the message text as an argument
//		It should create a Message object and add it to the arraylist (for the id, do something like messages.size() + 1)
//		It should return a redirect to /
//		In home.html, add a button or link called "Delete" next to each message
//		It will need to send the id as a parameter
//		In your controller, create a route for /delete-message
//		It should take the message id as an argument (the type should be Integer)
//		It should remove the message with the given id (do something like messages.remove(id - 1))
//		It should return a redirect to /