package com.person.view;

import java.util.UUID;
import com.user.model.User;
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
public class PersonCreateView {

  private String uuid = UUID.randomUUID().toString();
  private User user;
  private String firstName;
  private String surname;
  private String email;

  public PersonCreateView(User user, String firstName, String surname, String email) {
    this.user = user;
    this.firstName = firstName;
    this.surname = surname;
  }

}
