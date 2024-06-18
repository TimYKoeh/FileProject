package com.document.model;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@ToString
@Getter
@Setter
@MappedSuperclass
//@Table(name = "datei")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Document implements Comparable<Document> {

  @Id
  private String uuid;

  @ToString.Exclude
  @Column()
  private String pathname;
  @Column()
  private String name;
  @Column(name = "typ")
  private String type;
  @Column(name = "dateigroesse")
  long filesize;
  @Column(name = "aenderungsdatum")
  long dateChanged;


  @Override
  public int compareTo(Document b) {

    if (this.getDateChanged() > b.getDateChanged()) {
      return -1;
    }
    if (this.getDateChanged() < b.getDateChanged()) {
      return 1;
    } else {
      return 0;
    }
  }


}
