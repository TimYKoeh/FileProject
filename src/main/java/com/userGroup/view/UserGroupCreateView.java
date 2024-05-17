package com.userGroup.view;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import com.album.model.Album;
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
public class UserGroupCreateView {

  String uuid = UUID.randomUUID().toString();
  String name;
  List<User> user;
  List<Album> albums;

  public UserGroupCreateView(String name, List<User> user, List<Album> albums) {
    this.name = name;
    this.user = user;
    this.albums = albums;
  }

  public UserGroupCreateView(String name) {
    this.name = name;
    this.user = new LinkedList<User>();
    this.albums = new LinkedList<Album>();
  }
}
