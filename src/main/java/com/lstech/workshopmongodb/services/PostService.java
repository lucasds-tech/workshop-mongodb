package com.lstech.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lstech.workshopmongodb.domain.Post;
import com.lstech.workshopmongodb.exception.ObjectNotFoundException;
import com.lstech.workshopmongodb.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTittle(String text) {
		return repo.findByTittleContainingIgnoreCase(text);
	}
}
