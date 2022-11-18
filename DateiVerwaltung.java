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
  private DataListHelper datalisthelper = new DataListHelper();
  private MetaDataConnector metadataConnector = new drewMetadataConnector();
  private FileMover filemover = new FileMover();

  public DateiVerwaltung() {
    startDateiVerwaltung();
  }



  public void startDateiVerwaltung() {
    erstelleListenFuerDir();
    addAllFilesInDirectory(dateiAblage.toFile());
  }

  private void erstelleListenFuerDir() {
    for (File f : showFolders()) {
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
    Datei dat = new Datei(f.toPath());
    if (testForImg(dat)) {
      Optional<BildMetadata> meta = metadataConnector.getMetadData(f);
      if(meta.isPresent()) {
       matchListToDirectory(dir)
          .add(new Bild(f.toPath(), dat.getId(), meta.get()));
      }
    } else {
      matchListToDirectory(dir).add(new Datei(f.toPath(), dat.getId()));
    }

  }

  private boolean testForImg(Datei dat) {
    return dat.updateTyp().toUpperCase().startsWith("IMAGE");   
  }


  public void addFileToItsDirWithId(File f, File dir, int id) {
    matchListToDirectory(dir).add(new Datei(f.toPath(), id));
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
    return mapDirToList
        .entrySet()
        .stream()
        .filter((a) -> a.getValue().equals(liste))
        .findAny()
        .get()
        .getKey()
        .getName();
  }

  private LinkedList<Datei> matchListToDirectory(File dir) {
    return mapDirToList.get(dir);

  }



  private File[] showFolders() {
    return dateiAblage.toFile().listFiles();
  }


  public void sortListen() {
    sammlungen.stream().forEach((b) -> Collections.sort(b));
  }


  public void moveDateiTo(Datei b, Path to) {
    List<Datei> listBefore = matchListToDirectory(b.returnParentFile());
    List<Datei> listAfter = matchListToDirectory(to.toFile());
    filemover.moveDateiTo(b, to, listBefore, listAfter);
  }


  public void renameFileByIdInDir(int id, String name, File dir) {
    returnDateiById(id).changeNameInDirectory(dir, name);
  }

  public Datei returnDateiById(int i) {

    for (LinkedList<Datei> liste : sammlungen) {
      if (datalisthelper.MatchInListWithPred(liste, datalisthelper.matchesId(i))) {
        return datalisthelper.findDateiWithPred(liste, datalisthelper.matchesId(i));
      }
    }
    return null;
  }

  public Datei returnDateiByName(String name) {
    for (LinkedList<Datei> liste : sammlungen) {
      if (datalisthelper.MatchInListWithPred(liste, datalisthelper.matchesName(name))) {
        return datalisthelper.findDateiWithPred(liste, datalisthelper.matchesName(name));
      }
    }
    return null;
  }

}
