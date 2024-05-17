package com.user.view;

import java.util.List;
import com.person.model.Person;
import com.userGroup.model.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateView {

  private String name;
  private String password;
  private List<UserGroup> userGroups;
  private Person person;



}
