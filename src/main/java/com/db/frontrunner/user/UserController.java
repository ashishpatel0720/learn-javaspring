package com.db.frontrunner.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
either you can use
 */

@RestController    // This means that this class is a Controller
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class UserController {

	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@PostMapping // Map ONLY GET Requests

	public User addNewUser (@RequestBody User user) { //dependency injection
	    userRepository.save(user);
	    return user;
	}

	@GetMapping
	public Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}