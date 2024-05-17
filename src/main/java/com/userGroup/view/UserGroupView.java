package com.userGroup.view;

import java.util.List;
import com.album.model.Album;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.user.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserGroupView {

  private String uuid;
  private String name;
  @JsonIgnoreProperties("userGroups")
 /* private List<User> user;
  @JsonIgnoreProperties("userGroups")
  private List<Album> albums;
*/
  public UserGroupView(String uuid, String name, List<User> user, List<Album> albums) {
    this.uuid = uuid;
    this.name = name;
    /*
    this.user = user;
    this.albums = albums;
    */
  }
}
