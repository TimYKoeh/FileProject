package com.album.model;

import java.util.LinkedList;
import java.util.List;
import com.document.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.userGroup.model.UserGroup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name= "sammlungen")
@NoArgsConstructor
public class Album {

  @Id
  @Column(name = "sammlung_Id")
  private @Setter @Getter String uuid;


  private String name;

  @ManyToMany
  @JsonIgnoreProperties("albums")
  @JoinTable(
      name= "benutzergruppe_sammlungen",
      joinColumns = @JoinColumn(name = "sammlungen_id"),
     inverseJoinColumns = @JoinColumn(name = "benutzergruppen_id"))
  private List<UserGroup> userGroups;


  @ManyToMany
  @JsonIgnoreProperties("albums")
  @JoinTable(
      name= "sammlung_datei",
      joinColumns = @JoinColumn(name = "sammlungs_id"),
     inverseJoinColumns = @JoinColumn(name = "bild_Id"))
  private List<Image> pictures;

  public Album(String uuid, String name) {
    this.uuid = uuid;
    this.name = name;
    this.userGroups = new LinkedList<>();
    this.pictures = new LinkedList<>();
  }


  /*
  public List<Image> getPictures(){
    return pictures;
  }

  public void setPictures(List<Image> picturesNew) {
    this.pictures = picturesNew;
  }

  public List<UserGroup> getUserGroups(){
    return userGroups;
  }

  public void setUserGroups(List<UserGroup> userGroupNew) {
    this.userGroups = userGroupNew;
  }

  public void setUuid(String uuidNew) {
    this.uuid = uuidNew;
  }
*/
}
