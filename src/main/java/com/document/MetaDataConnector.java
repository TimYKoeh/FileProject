package com.document;
import java.util.Optional;
import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File;
import com.document.model.Metadata;

public interface MetaDataConnector {

    public Optional<Metadata> getMetadData(File file);

}
