import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ValueFormatter {
  public static final int B_GROESSE_LIMIT = 1024;
  
  public static String formatAenderungsDatum(long date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    return sdf.format(date);
  }
  
  public static String formatDateiGroesse(long dateiGroesse) {
    DecimalFormat decimalFormatter = new DecimalFormat("0.00");
    float tempGroesse = dateiGroesse;
    if(dateiGroesse <= byteSizes.byteSizeMax.Limit) {
      return decimalFormatter.format(tempGroesse) + " b";
    }else if (dateiGroesse >= byteSizes.byteSizeMax.Limit && dateiGroesse < byteSizes.kByteSizeMax.Limit) {
      return decimalFormatter.format(tempGroesse /= 1024) + " kb";
    }else if(dateiGroesse >= byteSizes.kByteSizeMax.Limit && dateiGroesse < byteSizes.mByteSizeMax.Limit) {
      return decimalFormatter.format(tempGroesse /= (1024*2)) + " mb";
    }else return decimalFormatter.format(tempGroesse /= (1024*3)) + " gb";
  }
  
  public enum byteSizes{
    byteSizeMax(B_GROESSE_LIMIT),
    kByteSizeMax(B_GROESSE_LIMIT*B_GROESSE_LIMIT),
    mByteSizeMax(B_GROESSE_LIMIT*B_GROESSE_LIMIT*B_GROESSE_LIMIT),
    gByteSizeMax(B_GROESSE_LIMIT*B_GROESSE_LIMIT*B_GROESSE_LIMIT*B_GROESSE_LIMIT);
    
    private int Limit;
    
    byteSizes(int Limit){
      this.Limit = Limit;
    }
  }
}
