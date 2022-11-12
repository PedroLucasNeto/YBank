package br.com.Bank.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;
@Entity	
@Data
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 100)
	private String name;
	
	@Column(unique=true, length = 20)
	private String login;
	
	@Column(length = 8)
	private String password;
	
	@Email
	@Column(unique=true)
	private String email;

}
