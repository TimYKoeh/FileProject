package com.userGroup.model;

import java.util.List;
import com.album.model.Album;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "benutzergruppe")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup {

  @Id
  @Column(name = "gruppen_id")
  String uuid;
  String name;

  @JsonIgnoreProperties("userGroups")
  @ManyToMany(mappedBy = "userGroups")
  private List<User> user;

  @JsonIgnoreProperties("userGroups")
  @ManyToMany(mappedBy = "userGroups")
  private List<Album> albums;

  public UserGroup(String uuid, String name) {
    this.uuid = uuid;
    this.name = name;
  }
}
