package com.user;

import java.util.LinkedList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.user.model.User;

public interface UserRepository extends CrudRepository<User, String>, FilteredUserRepository{

  @Override
  LinkedList<User> findAll();
  List<User> findByNameContainingIgnoreCase(String name);
  List<User> findByPersonVornameContainingIgnoreCase(String vorname);
  List<User> findByPersonNachnameContainingIgnoreCase(String nachname);
  List<User> findByPersonEmailContainingIgnoreCase(String email);
}
