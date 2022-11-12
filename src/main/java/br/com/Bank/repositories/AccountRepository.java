package br.com.Bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Bank.model.User;

public interface AccountRepository extends JpaRepository<User, Long> {

}
