package com.document.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metadata")
public class Metadata {


  @Id
  @Column(name = "uuid")
  private String uuid;


  @JsonIgnore
  @OneToOne
  @ToString.Exclude
  @JoinColumn(name="bild_id", referencedColumnName="uuid")
    private Image picture;

    @Column(name = "breitepix")
    private Long pixelWidth;
    @Column(name = "hoehepix")
    private Long pixelHeight;
    @Column(name = "kamerahersteller")
    private String cameraManufacturer;
    @Column(name = "aufnahmedatum")
    private String dateTaken;


    public Metadata(String uuid, Long pixelWidth, Long pixelHeight, String cameraManufacturer, String dateTaken) {
      this.uuid = uuid;
      this.pixelWidth = pixelWidth;
      this.pixelHeight = pixelHeight;
      this.cameraManufacturer = cameraManufacturer;
      this.dateTaken = dateTaken;
    }

    public String getPixMase() {
      return " " + getPixelWidth()+ " x " + getPixelHeight() + " Pixel";
    }
}
