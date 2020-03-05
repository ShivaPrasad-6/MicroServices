package com.cts.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.cts.project.pojos.User;

public interface UserRepository extends CrudRepository<User,String> {

	User findByUsernameAndPasswordAndConfirm(String username,String password,String confirm);

	Optional<User> findByEmail(String emailId);

	
}
