package com.user;

import java.util.LinkedList;
import org.springframework.data.repository.CrudRepository;
import com.user.model.User;

public interface UserRepository extends CrudRepository<User, String>, FilteredUserRepository{

  @Override
  LinkedList<User> findAll();
}
