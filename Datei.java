import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Datei implements Comparable<Datei> {

                     private int id;
                     private static int counter = 0;
  @ToString.Exclude  private String pathName;
                     private String name;
                     private String typ;
  @ToString.Exclude  private Path path;
  @ToString.Exclude  long dateiGroesse;
  @ToString.Exclude  long aenderungsDatum;
  
  @Builder
  public Datei(String pathName) {
    this.id = ++counter;
    this.pathName = pathName;
    pullInfos();
  }
  @Builder
  public Datei(String pathName, int id) {
    if (counter < id)
      counter = id;
    this.id = id;
    this.pathName = pathName;
    pullInfos();
  }
  
  private void pullInfos() {
    path = Paths.get(pathName);
    name = updateName();
    typ = updateTyp();
    dateiGroesse = updateDateiGroesse();
    aenderungsDatum = updateAenderungsDatum();
  }

  public Optional<String> formatTypEndung() {
    return Optional.ofNullable(file().toString()).filter(f -> f.contains("."))
        .map(f -> f.substring(file().toString().lastIndexOf(".") + 1));

  }

 @ToString.Include(name = "Aenderungs Datum") public String formatAenderungsDatum() {
    return ValueFormatter.formatAenderungsDatum(file().lastModified());
  }



  public File file() {
    return new File(pathName);
  }

  public File returnParentFile() {
    return file().getParentFile();
  }

  @ToString.Include(name = "Datei groesse") String formatDateiGroesse() {
    return ValueFormatter.formatDateiGroesse(dateiGroesse);
  }
 
  @Override
  public int compareTo(Datei b) {

    if (this.getAenderungsDatum() > b.getAenderungsDatum())
      return -1;
    if (this.getAenderungsDatum() < b.getAenderungsDatum())
      return 1;
    else
      return 0;
  }


  public void updateNameInDirectory() {
    File rename = new File(path + "\\" + getName() + formatTypEndung());
    path.toFile().renameTo(rename);
    this.path = Paths.get(rename.getPath());
  }

  public String updateTyp() {
    String DataType;
    try {
      DataType = Files.probeContentType(path);
    } catch (IOException ioE) {
      System.out.println("Typ der File kann nicht erkannt werden. File: " + path.toString());
      ioE.printStackTrace();
      DataType = "Error";
    }
    return DataType;
  }

  public long updateDateiGroesse() {
    return file().length();
  }

  public String updateName() {
    return file().getName().replaceFirst("[.][^.]+$", "");
  }

  public long updateAenderungsDatum() {
    return file().lastModified();
  }
  
}
