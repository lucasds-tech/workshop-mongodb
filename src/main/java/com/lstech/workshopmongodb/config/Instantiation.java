package com.lstech.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lstech.workshopmongodb.domain.Post;
import com.lstech.workshopmongodb.domain.User;
import com.lstech.workshopmongodb.dto.AuthorDTO;
import com.lstech.workshopmongodb.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(carlos, lucas, diogenes));
		
		Post post1 = new Post(null, sdf.parse("21/01/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(carlos));
		Post post2 = new Post(null, sdf.parse("23/01/2025"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(carlos));
		
		CommentDTO c1 = new CommentDTO("Boa viagem cara!", sdf.parse("21/01/2025"), new AuthorDTO(lucas));
		CommentDTO c2 = new CommentDTO("Aproveite bem!", sdf.parse("22/01/2025"), new AuthorDTO(diogenes));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/01/2025"), new AuthorDTO(lucas));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		carlos.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(carlos);
	}

}
