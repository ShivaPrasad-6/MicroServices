package cts.user.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cts.user.pojo.User;


public interface UserRepository extends CrudRepository<User,String> {

	User findByUsernameAndPasswordAndConfirm(String username,String password,String confirm);

	Optional<User> findByEmail(String emailId);
	

}
