package com.document.model;
import java.util.List;
import com.album.model.Album;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "datei")
@NoArgsConstructor
@AllArgsConstructor
public class Image extends Document {
  @ToString.Exclude
  @OneToOne(mappedBy = "picture")
  private Metadata metadata;

  @JsonIgnoreProperties("pictures")
  @ManyToMany(mappedBy = "pictures")
  private List<Album> albums;


  public Image(String uuid, String pathname, String name, String type, long filesize, long dateChanged, Metadata metadata) {
    super(uuid, pathname, name, type, filesize, dateChanged);
    this.metadata = metadata;
  }

  public Image(String uuid, String pathname, String name, String type, long filesize, long dateChanged) {
    super(uuid, pathname, name, type, filesize, dateChanged);
  }


}
