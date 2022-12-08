import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileSystemDirectory;
import com.drew.metadata.file.FileTypeDirectory;
import com.drew.metadata.jpeg.JpegDirectory;

public class MetadataMapper {


  public static BildMetadata mapToBildMetadata(Metadata metadata) {
    
      
    return new BildMetadata.BildMetadataBuilder()
        .breitePix(removeConcatPixel(getProperty(metadata, DirectoryClasses.jpegDir.directoryClass, "Image Width")))
        .hoehePix(removeConcatPixel(getProperty(metadata, DirectoryClasses.jpegDir.directoryClass, "Image Height")))
        .kameraHersteller(getProperty(metadata, DirectoryClasses.CameraDir.directoryClass, "Make"))
        .aufnahmeDatum(getProperty(metadata, DirectoryClasses.AvgDir.directoryClass, "Date/Time"))
        .build();
    
  }


  private static String getProperty(Metadata metadata, Class dirClass, String tagName) {
    try {
      return metadata.getFirstDirectoryOfType(dirClass)
        .getTags()
        .stream()
        .filter((Tag a) -> a.getTagName().equals(tagName))
        .findAny()
        .map((a) -> a.getDescription())
        .orElse("<N/a>");
    }catch(NullPointerException e) {
      return "<N/a>";
    }
  }
 
  
  private static String removeConcatPixel(String property) {
    if(property.contains("pixels")) {
      property = property.replace("pixels", "").trim();
    }
    return property;
  }
  
  enum DirectoryClasses
  {
    jpegDir(JpegDirectory.class),
    CameraDir(ExifIFD0Directory.class),
    FileTypeDir(FileTypeDirectory.class),
    FileSysDir(FileSystemDirectory.class),
    AvgDir(ExifSubIFDDirectory.class);
    
    private Class directoryClass;
    
    DirectoryClasses(Class directoryClass) {
      this.directoryClass = directoryClass;
    }

  }
}
