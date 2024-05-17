package com.document.view;

import java.util.List;
import com.album.model.Album;
import com.document.model.Metadata;
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
public class ImageUpdateView {

  String pathname;
  String name;
  String type;
  long filesize;
  long dateChanged;
  Metadata metadata;
  List<Album> albums;
}
