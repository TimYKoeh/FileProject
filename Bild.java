import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Bild extends Datei {
  @ToString.Exclude     private BildMetadata bildmetadata;
  @ToString.Exclude     private String breitePix;
  @ToString.Exclude     private String hoehePix;
                        private String kameraHersteller;
                        private String aufnahmeDatum;
  
  public Bild(String pathName) {
    super(pathName);
    pullMetadata();
  }

  public Bild(String pathName, int id) {
    super(pathName, id);
    pullMetadata();
  }

  public Bild(String pathName, int id, BildMetadata bildmetadata) {
    super(pathName, id);
    this.bildmetadata = bildmetadata;
    pullMetadata();
  }

  public void setMetdata(BildMetadata bildmetadata) {
    this.bildmetadata = bildmetadata;
  }

  private void pullMetadata() {
    this.breitePix = bildmetadata.getBreitePix();
    this.hoehePix = bildmetadata.getHoehePix();
    this.kameraHersteller = bildmetadata.getKameraHersteller();
    this.aufnahmeDatum = bildmetadata.getAufnahmeDatum();
  }

  @ToString.Include(name = "Pixelmasze") String getPix() {
    return bildmetadata.getPixMase();
  }

  public void showMeta() {
    bildmetadata.showMetaDaten();
  }
}

