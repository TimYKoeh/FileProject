import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileMover {

  
  
  public void moveDateiTo(Datei b, Path to, List<Datei> listBefore, List<Datei> listAfter) {
    copyBildTo(b, to, listAfter);
    removeDateiFromItsDir(b, listBefore);
  }

  public void removeDateiFromItsDir(Datei b, List<Datei> list) {
    list.remove(b);
    b.returnFileOfDatei().delete();
  }

  private void copyBildTo(Datei b, Path to,  List<Datei> list) {
    copyFromTo(b.getPath(), to);
    list.add(b);
  }

  private void copyFromTo(Path from, Path to) {
    try {
      Files.copy(from, evaluatePathName(to.toString(), from.getFileName()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private Path evaluatePathName(String path, Path name) {
    return Paths.get(path + "\\" + name);
  }

}
