package com.thiagofarias.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagofarias.workshopmongo.domain.User;
import com.thiagofarias.workshopmongo.dto.UserDTO;
import com.thiagofarias.workshopmongo.repository.UserRepository;
import com.thiagofarias.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		
		return repo.findAll();
		
	}
	
	public User findById(String id) {
		
		Optional<User> user = repo.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public User insert(User obj) {
		
		return repo.insert(obj);
		
	}
	
	public User fromDTO(UserDTO objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
	
	public void delete(String id) {
		
		findById(id);
		repo.deleteById(id);
		
	}
}
