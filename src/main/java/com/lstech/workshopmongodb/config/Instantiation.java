package com.lstech.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lstech.workshopmongodb.domain.Post;
import com.lstech.workshopmongodb.domain.User;
import com.lstech.workshopmongodb.repository.PostRepository;
import com.lstech.workshopmongodb.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User carlos = new User(null, "Carlos Silva", "carlos@gmail.com");
		User lucas = new User(null, "Lucas Silva", "lucas@gmail.com");
		User diogenes = new User(null, "Diogenes Azevedo", "diogenes@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/01/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", carlos);
		Post post2 = new Post(null, sdf.parse("23/01/2025"), "Bom dia", "Acordei feliz hoje!", carlos);
		
		userRepository.saveAll(Arrays.asList(carlos, lucas, diogenes));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
