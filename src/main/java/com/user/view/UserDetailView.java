package com.user.view;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import com.userGroup.model.UserGroup;
import com.userGroup.view.UserGroupView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetailView {

  private String uuid;
  private String name;
  private String vorname;
  private String nachname;
  private String email;
  private List<UserGroupView> userGroups;

  public UserDetailView(String uuid, String name, String vorname, String nachname, String email, List<UserGroupView> userGroups) {
    this.uuid = uuid;
    this.name = name;
    this.vorname = vorname;
    this.nachname = nachname;
    this.email = email;
    this.userGroups = userGroups;
  }
  
  public UserDetailView(String name, String vorname, String nachname, String email, List<UserGroupView> userGroups) {
    this.uuid = UUID.randomUUID().toString();
    this.name = name;
    this.vorname = vorname;
    this.nachname = nachname;
    this.email = email;
    this.userGroups = userGroups;
  }
}
