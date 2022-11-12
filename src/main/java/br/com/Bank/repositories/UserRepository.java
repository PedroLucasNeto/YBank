package br.com.Bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Bank.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByName(String name);
	
	public List<User> findAll();

	public User findByLogin(String login);

	public User findByEmail(String login);
	
}
