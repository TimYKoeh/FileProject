package com.user;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.model.User;
import com.user.view.UserCreateView;
import com.user.view.UserUpdateView;
import com.user.view.UserView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class UserService {

  @Autowired
  private UserRepository repository;
  @Autowired
  public UserMapper mapper;


  public List<Optional<UserView>> getList(String uuid, String name, String password){
    return repository.getUserList(uuid, name, password).stream().map((User benutzer) -> mapper.toOptionalView(Optional.of(benutzer))).toList();
  }

  public Optional<UserView> get(String uuid){
    Optional<User> optionalUser = repository.findById(uuid);
    return mapper.toOptionalView(optionalUser);
  }



  public Optional<UserView> update(UserUpdateView userUpdated, String uuid) {
    return mapper
        .toOptionalView(repository.findById(uuid)
            .map(user -> {
      User updatedUser = keepPreviousRelations(mapper.update(userUpdated), user);
      updatedUser.setUuid(uuid);

      repository.save(updatedUser);
      return updatedUser;
    }));
  }

  private User keepPreviousRelations(User mappedUser, User savedUser) {
    if(mappedUser.getUserGroups() == null) {
      mappedUser.setUserGroups(savedUser.getUserGroups());
    }
    if(mappedUser.getPerson() == null) {
      mappedUser.setPerson(savedUser.getPerson());
    }
    return mappedUser;
  }


  public Optional<UserView> delete(String uuid) {
    Optional<User> optionalBenutzer = repository.findById(uuid);

    optionalBenutzer.ifPresent(benutzer -> {
      Hibernate.initialize(benutzer.getUserGroups());
      Hibernate.initialize(benutzer.getPerson());
      repository.delete(benutzer);
    });
    return mapper.toOptionalView(optionalBenutzer);
  }

  public Optional<UserView> save(UserCreateView user) {
    return mapper.toOptionalView(Optional.of(repository.save(mapper.create(user))));
  }


}
