import java.io.File;
import java.util.Optional;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileSystemDirectory;
import com.drew.metadata.file.FileTypeDirectory;
import com.drew.metadata.jpeg.JpegDirectory;

public class drewMetadataConnector implements MetaDataConnector {


  @Override
  public Optional<BildMetadata> getMetadData(File file){
   
    try { 
      Metadata metadata = ImageMetadataReader.readMetadata(file);
      return Optional.of(MetadataMapper.mapToBildMetadata(metadata));
      
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
   
  }

  public void showAllMeta(Metadata metadata) {
    for (Directory dir : metadata.getDirectories()) {
      for (Tag tag : dir.getTags()) {
        System.out.println(tag);
      }
    }
  }

}
