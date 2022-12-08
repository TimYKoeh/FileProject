import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DateiVerwaltung {

  private List<LinkedList<Datei>> sammlungen = new ArrayList<>();
  private Path dateiAblage =
      Paths.get("C:\\Users\\tikoehler\\eclipse-workspace\\BildProjekt\\bilderAblage\\");
  private HashMap<File, LinkedList<Datei>> mapDirToList = new HashMap<>();
  private MetaDataConnector metadataConnector = new drewMetadataConnector();

  public DateiVerwaltung() {
    startDateiVerwaltung();
  }



  public void startDateiVerwaltung() {
    erstelleListenFuerDir();
    addAllFilesInDirectory(dateiAblage.toFile());
  }

  private void erstelleListenFuerDir() {
    for (File f : dateiAblage.toFile().listFiles()) {
      mapDirToList.putIfAbsent(f, new LinkedList<Datei>());
      sammlungen.add(mapDirToList.get(f));
    }
  }



  private void addAllFilesInDirectory(File dir) {
    File[] files = dir.listFiles();
    for (File f : files) {
      if (f.isDirectory()) {
        addAllFilesInDirectory(f);
      } else {
        addFileToItsDir(f, dir);
      }
    }
  }

  public void addFileToItsDir(File f, File dir) {
    matchListToDirectory(dir).add(ensureInheritedType(new Datei(f.toString())));
  }
  
  private Datei ensureInheritedType(Datei datei) {
      Optional<BildMetadata> meta = metadataConnector.getMetadData(datei.file());
      if (meta.isPresent()) {
        return new Bild(datei.getPathName(), datei.getId(), meta.get());
      }else {
        return new Datei(datei.getPathName(), datei.getId());
      }
  }

  private void zeigeSammlung(List<Datei> liste) {
    String indent = "   ";
    System.out.println(returnDirNameOfList(liste) + ":");
    if (liste.isEmpty()) {
      System.out.println(indent + "<Leer>");
    } else {
      liste.stream().forEach((b) -> System.out.println(indent + b.toString()));
    }

  }

  public void zeigeDateiSammlungen() {
    sammlungen.stream().forEach((b) -> zeigeSammlung(b));
  }



  private String returnDirNameOfList(List<Datei> liste) {
    return mapDirToList.entrySet().stream().filter((a) -> a.getValue().equals(liste)).findAny()
        .get().getKey().getName();
  }

  private LinkedList<Datei> matchListToDirectory(File dir) {
    return mapDirToList.get(dir);

  }



  public void sortListen() {
    sammlungen.stream().forEach((b) -> Collections.sort(b));
  }


  public void moveDateiTo(Datei b, Path to) {
    FileMover.moveDateiTo(b, to, matchListToDirectory(b.returnParentFile()),
        matchListToDirectory(to.toFile()));
  }



  public Datei returnDateiById(int i) {

    for (LinkedList<Datei> liste : sammlungen) {
      if (DataListHelper.matchInListWithPred(liste, DataListHelper.matchesId(i))) {
        return DataListHelper.findDateiWithPred(liste, DataListHelper.matchesId(i));
      }
    }
    return null;
  }

  public Datei returnDateiByName(String name) {
    for (LinkedList<Datei> liste : sammlungen) {
      if (DataListHelper.matchInListWithPred(liste, DataListHelper.matchesName(name))) {
        return DataListHelper.findDateiWithPred(liste, DataListHelper.matchesName(name));
      }
    }
    return null;
  }

}
