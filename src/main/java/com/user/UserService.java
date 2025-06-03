package com.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.model.User;
import com.user.view.UserDetailView;
import com.user.view.UserView;
import com.userGroup.view.UserGroupView;
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


  public Optional<UserDetailView> getDetailView(String uuid){
    return mapper.toOptionalUserDetailView(repository.findById(uuid));
  }
  
  public Optional<List<UserGroupView>> getUserAssociatedUserGroups(String userId) {
    return repository.findById(userId)
                     .map(user -> user.getUserGroups()
                                      .stream()
                                      .map(mapper::toUserGroupView)
                                      .collect(Collectors.toList()));
}


  public List<Optional<UserView>>findContaining(String query){
    return Stream.of(
        repository.findByNameContainingIgnoreCase(query),
        repository.findByPersonVornameContainingIgnoreCase(query),
        repository.findByPersonNachnameContainingIgnoreCase(query),
        repository.findByPersonEmailContainingIgnoreCase(query)
        )
        .flatMap(List::stream)
        .distinct()
        .map(benutzer -> mapper.toOptionalView(Optional.of(benutzer)))
        .collect(Collectors.toList());
  }
  
  
  


  public Optional<UserView> update(UserDetailView userUpdated, String uuid) {
    return mapper
        .toOptionalView(repository.findById(uuid)
            .map(user -> {
      User updatedUser = keepPreviousRelations(mapper.fromUserDetailView(userUpdated), user);
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
  
  

  public Optional<UserView> save(UserDetailView user) {
    user.setUuid(UUID.randomUUID().toString());
    return mapper.toOptionalView(Optional.of(repository.save(mapper.fromUserDetailView(user))));
  }


}
