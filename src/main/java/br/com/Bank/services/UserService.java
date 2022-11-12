package br.com.Bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Bank.CreatingErrorException;
import br.com.Bank.TokenNotFoundException;
import br.com.Bank.model.User;
import br.com.Bank.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) throws CreatingErrorException {
		
		if (userRepository.findByEmail(user.getEmail()) != null || userRepository.findByLogin(user.getLogin()) != null ) {
			throw new CreatingErrorException("We are sorry. An error ocurred.");
		}
		return userRepository.save(user);
	}

	public User findById(Long id) throws CreatingErrorException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new CreatingErrorException("We are sorry. An error ocurred.");
		}

		return user.get();

	}

	public List<User> findByName(String name) {
		List<User> list = userRepository.findByName(name);
		return list;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public User update(Long id) throws CreatingErrorException {

		Optional<User> user = userRepository.findById(id);
		User updatedUser = new User();

		if (user.isPresent()) {
			updatedUser.setEmail(user.get().getEmail());
		} else {
			throw new CreatingErrorException("We are sorry. An error ocurred.");
		}
		return userRepository.save(updatedUser);
	}

	public User updateUser(User user) throws TokenNotFoundException {
		
		Optional<User> updateUser = userRepository.findById(user.getId());
		
		if (!updateUser.isPresent()) {
			throw new TokenNotFoundException("We couldn't found this.");
		}
		updateUser.get().setEmail(user.getEmail());
		updateUser.get().setName(user.getName());
		updateUser.get().setPassword(user.getPassword());
		
		return userRepository.save(updateUser.get());
	}
	
	public List<User> findUserByNameStartingWith(String name){
		
		//TODO Create method that returns a list of users starting with that name.
		return null;
	}

}
