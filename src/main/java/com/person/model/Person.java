  package com.person.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.user.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "person")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @Id
  @Column(name = "benutzer_id")
  private String uuid;

  @JsonIgnore
  @ToString.Exclude
  @OneToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "benutzer_id", referencedColumnName = "uuid")
  private User user;


  @Column(name = "vorname")
  private String firstName;

  @Column(name = "nachname")
  private String surname;

  private String email;

  public Person(String uuid, String vorname, String nachname, String email) {
    this.uuid = uuid;
    this.firstName = vorname;
    this.surname = nachname;
    this.email = email;
  }
}
