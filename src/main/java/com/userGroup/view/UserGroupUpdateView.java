package com.userGroup.view;

import java.util.List;
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
public class UserGroupUpdateView {

  String name;
  List<User> user;
  List<Album> albums;
}
