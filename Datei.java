import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Optional;

public class Datei implements Comparable<Datei> {
  public static final int B_GROESSE_LIMIT = 1024;
  public static final int KB_GROESSE_LIMIT = B_GROESSE_LIMIT * B_GROESSE_LIMIT;
  public static final int MB_GROESSE_LIMIT = KB_GROESSE_LIMIT * B_GROESSE_LIMIT;
  public static final int GB_GROESSE_LIMIT = MB_GROESSE_LIMIT * B_GROESSE_LIMIT;
  private int id;
  private static int counter = 0;
  private Path path;
  private String name;
  private long dateiGroesse;
  private long aenderungsDatum;
  private String typ;

  public Datei(Path path) {
    this.id = ++counter;
    this.path = path;
    this.name = updateName();
    this.typ = updateTyp();
    this.dateiGroesse = updateDateiGroesse();
    this.aenderungsDatum = updateAenderungsDatum();
  }

  public Datei(Path path, int id) {
    this.id = id;
    this.path = path;
    this.name = updateName();
    this.typ = updateTyp();
    this.dateiGroesse = updateDateiGroesse();
    this.aenderungsDatum = updateAenderungsDatum();
  }


  public String updateName() {
    return path.getFileName().toString().replaceFirst("[.][^.]+$", "");
  }

  public void updateNameInDirectory() {
    File rename = new File(path + "\\" + getName() + formatTypEndung());
    path.toFile().renameTo(rename);
    this.path = Paths.get(rename.getPath());
  }


  public void changeNameInDirectory(File directory, String name) {
    File rename = EvaluateNewFile(directory, name);
    returnFileOfDatei().renameTo(rename);
    this.path = Paths.get(rename.getPath());
    setName(name);
  }


  private File EvaluateNewFile(File directory, String name) {
    return new File(directory + "\\" + name + formatTypEndung());
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



  public Optional<String> formatTypEndung() {
    return Optional.ofNullable(showName()).filter(f -> f.contains("."))
        .map(f -> f.substring(showName().lastIndexOf(".") + 1));

  }

  private String showName() {
    return returnFileOfDatei().toString();


  }

  public String formatAenderungsDatum() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    return sdf.format(returnFileOfDatei().lastModified());
  }

  public long updateAenderungsDatum() {
    return returnFileOfDatei().lastModified();
  }

  public File returnFileOfDatei() {
    return path.toFile();
  }

  public long updateDateiGroesse() {
    return returnFileOfDatei().length();
  }

  public File returnParentFile() {
    return returnFileOfDatei().getParentFile();
  }

  public String parentFileName() {
    return path.getParent().getFileName().toString();
  }

  public String formatDateiGroesse() {
    DecimalFormat df = new DecimalFormat("0.00");
    float dateiGroesseDezimal = dateiGroesse;
    while (dateiGroesseDezimal > 1024) {
      dateiGroesseDezimal /= 1024;
    }
    return df.format(dateiGroesseDezimal) + " " + evaluateAnhaengsel();
  }

  private String evaluateAnhaengsel() {

    if (dateiGroesse <= B_GROESSE_LIMIT) {
      return "b";
    } else if (dateiGroesse > B_GROESSE_LIMIT && dateiGroesse <= KB_GROESSE_LIMIT) {
      return "kb";
    } else if (dateiGroesse > KB_GROESSE_LIMIT && dateiGroesse <= MB_GROESSE_LIMIT) {
      return "mb";
    } else {
      return "gb";
    }
  }

  @Override
  public String toString() {
    Formatter f = new Formatter();
    f.format(
        "ID: %-15d Name: %-15s Typ: %-15s Dateigroeße: %-15s zuletzt geändert: %-25s Dateipfad:%-10s",
        getId(), getName(), getTyp(), formatDateiGroesse(), formatAenderungsDatum(),
        path.toString());
    String bildInfos = f.toString();
    f.close();
    return bildInfos;

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


  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public Path getPath() {
    return path;
  }

  private void setPath(Path path) {
    this.path = path;
  }

  public long getDateiGroesse() {
    return dateiGroesse;
  }

  public long getAenderungsDatum() {
    return aenderungsDatum;
  }

  public String getTyp() {
    return typ;
  }


}
