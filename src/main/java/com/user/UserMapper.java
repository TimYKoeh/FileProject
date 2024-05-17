package com.user;

import java.util.Optional;
import org.mapstruct.Mapper;
import com.person.model.Person;
import com.user.model.User;
import com.user.view.UserCreateView;
import com.user.view.UserDetailView;
import com.user.view.UserUpdateView;
import com.user.view.UserView;

@Mapper(componentModel = "spring")//, uses = PersonMapper.class)
public interface UserMapper {

  public default Optional<UserView> toOptionalView(Optional<User> user){return user.map(this::toView);}
  public UserView toView(User user);
  public default Optional<User> fromOptionalView(Optional<UserView> view){return view.map(this::fromView);}
  public User fromView(UserView view);
  public User create(UserCreateView createView);
  public User update(UserUpdateView updateVew);
  public UserDetailView detailed(Optional<User> user, Optional<Person> person);
  }
