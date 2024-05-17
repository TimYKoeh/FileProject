package com.core;
/*package core;
import java.io.File;
import java.util.Optional;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import datei.model.BildMetadata;
import datei.model.MetaDataConnector;
import datei.model.MetadataMapper;
public class drewMetadataConnector implements MetaDataConnector {


  public Optional<BildMetadata> getMetadData(File file){
    try {
      Metadata metadata = ImageMetadataReader.readMetadata(file);
      return Optional.of(MetadataMapper.mapToBildMetadata(metadata));
    } catch (Exception e) {
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
*/