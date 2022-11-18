
public class BildMetadata {
    private String breitePix;
    private String hoehePix;
    private String kameraHersteller;
    private String aufnahmeDatum;
    
    public BildMetadata(String breitePix, String hoehePix, String kameraHersteller, String aufnahmeDatum) {
      this.breitePix = breitePix;
      this.hoehePix = hoehePix;
      this.kameraHersteller = kameraHersteller;
      this.aufnahmeDatum = aufnahmeDatum;
    }
    
    
    public String getBreitePix() {
      return breitePix;
    }

    public String getHoehePix() {
      return hoehePix;
    }

    public String getKameraHersteller() {
      return kameraHersteller;
    }

    public String getAufnahmeDatum() {
      return aufnahmeDatum;
    }

    
    public void showMetaDaten() {
      System.out.println("breitePix : " + getBreitePix() );
      System.out.println("hoehePix : " + getHoehePix());
      System.out.println("Kamerahersteller : " + getKameraHersteller());
      System.out.println("Aufnahmedatum : " + getAufnahmeDatum());
    }
    
}
