package com.phase3.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phase3.project.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsernameAndPassword(String username,String password);
	public User findByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.username like %?1%")
	public List<User> findByUsernameLike(String username);
}
