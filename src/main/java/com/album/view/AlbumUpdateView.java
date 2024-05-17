package com.album.view;

import java.util.List;
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
public class AlbumUpdateView {

  private String name;
  private List<UserGroup> userGroups;
  private List<Image> pictures;

}
