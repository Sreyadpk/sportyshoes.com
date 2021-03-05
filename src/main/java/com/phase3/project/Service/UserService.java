package com.phase3.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3.project.Entity.User;
import com.phase3.project.Repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}
	
	public User findById(int id) {
		Optional<User> us = userRepository.findById(id);
		return us.get();
	}
	
	public User getByUserPassword(String username,String password) {
		User user=userRepository.findByUsernameAndPassword(username, password);
		return user;
	}
	
	public List<User> findAllUsers(){
		List<User> users=userRepository.findAll();
		return users;
	}
	
	public List<User> getByUsernameLike(String keyword){
		
		if(keyword!=null) {
			List<User> us=userRepository.findByUsernameLike(keyword);
			return us;
		}
		List<User> users=userRepository.findAll();
		return users;
	}
	
}
