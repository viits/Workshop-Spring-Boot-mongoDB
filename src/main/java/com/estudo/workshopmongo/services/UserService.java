package com.estudo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.workshopmongo.domain.User;
import com.estudo.workshopmongo.dto.UserDTO;
import com.estudo.workshopmongo.repositories.UserRepository;
import com.estudo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}
	
	public User insert(User user) {
		user = userRepository.insert(user);
		return user;
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(),userDTO.getEmail());
	}
	
}
