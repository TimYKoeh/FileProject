package com.user.view;

import java.util.List;
import java.util.UUID;
import com.person.model.Person;
import com.userGroup.model.UserGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCreateView {
  private String name;
  private String password;
  private String uuid = UUID.randomUUID().toString();
  private List<UserGroup> benutzergruppen;
  private Person person;

  public UserCreateView(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public UserCreateView(String name, String password, List<UserGroup> benutzergruppen, Person person) {
    this.name = name;
    this.password = password;
    this.benutzergruppen = benutzergruppen;
    this.person = person;
  }

  public UserCreateView() {}
}
