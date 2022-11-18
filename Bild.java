import java.nio.file.Path;
import java.util.Formatter;

public class Bild extends Datei {
  BildMetadata bildmetadata;

  public Bild(Path path) {
    super(path);
  }

  public Bild(Path path, int id) {
    super(path, id);
  }

  public Bild(Path path, int id, BildMetadata bildmetadata) {
    super(path, id);
    this.bildmetadata = bildmetadata;
  }
  
  public void setMetdata(BildMetadata bildmetadata) {
    this.bildmetadata = bildmetadata;
  }

  public String getBreitePix() {
    return bildmetadata.getBreitePix();
  }

  public String getHoehePix() {
    return bildmetadata.getHoehePix();
  }

  public String getPix() {
    return bildmetadata.getBreitePix() + " x " + bildmetadata.getHoehePix();
  }

  public String getKameraHersteller() {
    return bildmetadata.getKameraHersteller();
  }

  public String getAufnahmeDatum() {
    return bildmetadata.getAufnahmeDatum();
  }

  public void showMeta() {
    bildmetadata.showMetaDaten();
  }

  @Override
  public String toString() {
    return super.toString() + metaDatenToString("    ");
  }

  public String metaDatenToString(String indent) {
    Formatter f = new Formatter();
    f.format("\n%s AufnahmeDatum: %-15s Kamerahersteller: %-25s Pixelmaße:%-10s", indent,
        getAufnahmeDatum(), getKameraHersteller(), getPix());
    String bildMeta = f.toString();
    f.close();
    return bildMeta;

  }
}
