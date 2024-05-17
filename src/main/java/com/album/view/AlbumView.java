package com.album.view;

import java.util.List;
import com.document.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class AlbumView {
  private String uuid;
  private String name;
  @JsonIgnoreProperties({"bilderSammlung", "albums"})
  private List<Image> pictures;
}
