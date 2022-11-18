import java.io.File;
import java.util.Optional;

public interface MetaDataConnector {

    public Optional<BildMetadata> getMetadData(File file);
    
}
