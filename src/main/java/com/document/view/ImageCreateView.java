package com.document.view;

import java.util.List;
import java.util.UUID;
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
public class ImageCreateView {

  String uuid = UUID.randomUUID().toString();
  String pathname;
  String name;
  String type;
  long filesize;
  long dateChanged;
  Metadata metadata;
  List<Album> albums;

  public ImageCreateView(String pathname, String name, String type, long filesize, long dateChanged, Metadata metadata, List<Album> albums) {
    this.pathname = pathname;
    this.name = name;
    this.type = type;
    this.filesize = filesize;
    this.dateChanged = dateChanged;
    this.metadata = metadata;
    this.albums = albums;
  }
}
