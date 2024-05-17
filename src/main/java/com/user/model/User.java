package com.user.model;

import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.person.model.Person;
import com.userGroup.model.UserGroup;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "benutzer")
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  private String uuid;
  private String name;
  private String password;

  @ManyToMany
  @JsonIgnoreProperties("benutzer")
  @JoinTable(
      name= "benutzer_benutzergruppe",
      joinColumns = @JoinColumn(name = "benutzer_uuid"),
     inverseJoinColumns = @JoinColumn(name = "benutzergruppe_uuid"))
  private List<UserGroup> userGroups;

  @ToString.Exclude
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private Person person;

  public User(String uuid, String name, String password) {
    this.uuid = uuid;
    this.name = name;
    this.password = password;
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    this.uuid = UUID.randomUUID().toString();
  }
}
