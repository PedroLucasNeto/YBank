package br.com.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.Bank.CreatingErrorException;
import br.com.Bank.TokenNotFoundException;
import br.com.Bank.model.User;
import br.com.Bank.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) throws CreatingErrorException {

		userService.createUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> list = userService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws CreatingErrorException {

		User user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/q")
	public ResponseEntity<List<User>> findByName(@RequestParam("name") String name) throws CreatingErrorException {

		List<User> list = userService.findByName(name);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id) throws CreatingErrorException {

		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) throws TokenNotFoundException {

		User updatedUser = userService.updateUser(user);

		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

}
