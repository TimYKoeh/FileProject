import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    Path verschiebungA =
        Paths.get("C:\\Users\\tikoehler\\eclipse-workspace\\BildProjekt\\bilderAblage\\Hallo");
    Path verschiebungB =
        Paths.get("C:\\Users\\tikoehler\\eclipse-workspace\\BildProjekt\\bilderAblage\\ImagesB");

    DateiVerwaltung bv = new DateiVerwaltung();
    bv.zeigeDateiSammlungen();
    //bv.moveDateiTo(bv.returnDateiByName("KatzenBild2"), verschiebungB);
    //bv.zeigeDateiSammlungen();
    
    
    
    /*Bild bild = new Bild(Paths.get("C:\\Users\\tikoehler\\eclipse-workspace\\BildProjekt\\bilderAblage\\ImagesB\\neuerNeuerName1.jpg"));
    drewMetadataConnector dMC = new drewMetadataConnector();
    dMC.getMetadData(bild.returnFileOfDatei());
    Metadata metadata;
     * bv.sortListen(); bv.zeigeDateiSammlungen();
     * 
     * Datei datei = new Datei(f.toPath()); datei.showTags(); Bild bild = new Bild(f.toPath());
     * bild.showTags(); File f = new File(
     * "C:\\Users\\tikoehler\\eclipse-workspace\\BildProjekt\\bilderAblage\\ImagesA\\KatzenBild7.jpg"
     * ); Bild bild = new Bild(f.toPath()); bild.showTags(); bv.zeigeDateiSammlungen();
     * bv.moveDateiTo(bv.returnDateiByName("KatzenBild8"), verschiebungB);
     * 
     * bv.zeigeDateiSammlungen();
     * File f = new File(
        "C:\\Users\\tikoehler\\eclipse-workspace\\BildProjekt\\bilderAblage\\IchHabeDenUmbenannt\\Kürbis.jpg");
    Metadata metadata;
    try {
      metadata = ImageMetadataReader.readMetadata(f);
       for (Directory dir : metadata.getDirectoriesOfType(Directory.class)) {
        for (Tag tag : dir.getTags()) {
          System.out.println(tag);
        }
      }
try {
      metadata = ImageMetadataReader.readMetadata(new File("C:\\\\Users\\\\tikoehler\\\\eclipse-workspace\\\\BildProjekt\\\\bilderAblage\\\\ImagesB\\\\neuerNeuerName1.jpg"));
       for (Directory dir : metadata.getDirectoriesOfType(Directory.class)) {
        for (Tag tag : dir.getTags()) {
          System.out.print(dir.toString() + " : ");
          System.out.println(tag);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    } catch (Exception e) {
      e.printStackTrace();
    }
     * public void showTags(Metadata metadata) { for (Directory directory :
     * metadata.getDirectories()) { for (Tag tag : directory.getTags()) { System.out.println(tag); }
     * } } Metadata metadata; try { metadata = ImageMetadataReader.readMetadata(f); for (Directory
     *
     *  for (Directory dir : metadata.getDirectoriesOfType(Directory.class)) {
        for (Tag tag : dir.getTags()) {
          System.out.println(tag);
        }
      }
     * Scanner sc = new Scanner(System.in);
     * System.out.println("Bitte geben sie die ID des gewünschten Bildes ein");
     * System.out.println(bv.getBildById(sc.nextInt()).toString()); sc.close();
     * 
     * bv.renameFileByIdInDir(1, "neuerNeuerName1", datei); System.out.println("--");
     * bv.zeigeBilder();
     * 
     * bv.moveFromTo(bv.getBildById(1).getPath(), bv.getPathImagesB());
     * 
     * System.out.println(bv.getAvgBilderSize());
     * 
     * bv.moveBildTo(bv.getBildById(1), bv.getPathImagesB());
     */
  }



}
