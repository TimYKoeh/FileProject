package com.album.view;

import java.util.List;
import java.util.UUID;
import com.document.model.Image;
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
public class AlbumCreateView {

  private String uuid = UUID.randomUUID().toString();
  private String name;
  private List<UserGroup> userGroups;
  private List<Image> pictures;

  public AlbumCreateView(String name, List<UserGroup> userGroups, List<Image> pictures) {
    this.name = name;
    this.userGroups = userGroups;
    this.pictures = pictures;
  }
}
