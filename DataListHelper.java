import java.util.List;
import java.util.function.Predicate;

public class DataListHelper {

  
  
  public boolean MatchInListWithPred(List<Datei> liste, Predicate<Datei> predicate) {
    return liste.stream().anyMatch(predicate);
  }

  public Datei findDateiWithPred(List<Datei> liste, Predicate<Datei> predicate) {
    return liste.stream().filter(predicate).findAny().get();
  }

  public Predicate<Datei> matchesId(int i) {
    return p -> p.getId() == i;
  }

  public Predicate<Datei> matchesName(String name) {
    return p -> p.getName().equals(name);
  }
}
