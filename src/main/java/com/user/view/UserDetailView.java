package com.user.view;

import java.util.List;
import com.userGroup.model.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailView {

  private String uuid;
  private String name;
  private String firstName;
  private String surName;
  private String email;
  private List<UserGroup> userGroups;

}
