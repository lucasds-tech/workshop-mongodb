package com.lstech.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lstech.workshopmongodb.domain.User;
import com.lstech.workshopmongodb.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User carlos = new User(null, "Carlos Silva", "carlos@gmail.com");
		User lucas = new User(null, "Lucas Silva", "lucas@gmail.com");
		User diogenes = new User(null, "Diogenes Azevedo", "diogenes@gmail.com");
		
		userRepository.saveAll(Arrays.asList(carlos, lucas, diogenes));
	}

}
