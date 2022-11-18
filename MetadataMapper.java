import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileSystemDirectory;
import com.drew.metadata.file.FileTypeDirectory;
import com.drew.metadata.jpeg.JpegDirectory;

public class MetadataMapper {
  private final static Class<JpegDirectory> JPEGDIR = JpegDirectory.class;
  private final static Class<ExifIFD0Directory> CAMERADIR = ExifIFD0Directory.class;
  private final static Class<FileTypeDirectory> FILETYPEDIR = FileTypeDirectory.class;
  private final static Class<FileSystemDirectory> FILESYSTEMDIR = FileSystemDirectory.class;
  private final static Class<ExifSubIFDDirectory> AVGDIR = ExifSubIFDDirectory.class;


  public static BildMetadata mapToBildMetadata(Metadata metadata) {
    return new BildMetadata(
        getProperty(metadata, JPEGDIR, "Image Width"),
        getProperty(metadata, JPEGDIR, "Image Height"),
        getProperty(metadata, CAMERADIR, "Make"),
        getProperty(metadata, CAMERADIR, "Date/Time")
        );
  }


  private static String getProperty(Metadata metadata, Class dirClass, String tagName) {
    return metadata.getFirstDirectoryOfType(dirClass)
        .getTags()
        .stream()
        .filter((Tag a) -> a.getTagName().equals(tagName))
        .findAny()
        .map((a) -> a.getDescription())
        .orElse("<N/a>");
  }
}
