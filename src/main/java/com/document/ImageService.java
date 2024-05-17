package com.document;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.document.model.Image;
import com.document.model.Metadata;
import com.document.view.ImageCreateView;
import com.document.view.ImageUpdateView;
import com.document.view.ImageView;
import lombok.NoArgsConstructor;

/**
 *
 * @author tikoehler
 *
 */
@NoArgsConstructor
@Service
public class ImageService{
  @Autowired
  ImageMapper mapper;
  @Autowired
  public ImageRepository repository;

  public List<Optional<ImageView>> getList(String uuid, String pathname, String name, String type){
    return repository.getFilteredList(uuid, pathname, name, type).stream().map((Image image) -> mapper.toOptionalView(Optional.of(image))).toList();
  }

  public Optional<ImageView> get(String uuid){
    return mapper.toOptionalView(repository.findById(uuid));
  }

  public Optional<ImageView> update(ImageUpdateView imageUpdated, String uuid) {
    return mapper
        .toOptionalView(repository.findById(uuid)
            .map(image -> {
      Image updatedImage = keepPreviousRelations(mapper.update(imageUpdated), image);
      updatedImage.setUuid(uuid);

      repository.save(updatedImage);
      return updatedImage;
    }));
  }

  private Image keepPreviousRelations(Image mappedImage, Image savedImage) {
    if(mappedImage.getAlbums() == null) {
      mappedImage.setAlbums(savedImage.getAlbums());
    }
    if(mappedImage.getMetadata() == null) {
      mappedImage.setMetadata(savedImage.getMetadata());
    }
    return mappedImage;
  }


  public Optional<ImageView> delete(String uuid) {
    Optional<Image> optionalImage = repository.findById(uuid);

    optionalImage.ifPresent(image -> {
      Hibernate.initialize(image.getAlbums());
      Hibernate.initialize(image.getMetadata());
      repository.delete(image);
    });
    return mapper.toOptionalView(optionalImage);
  }

  public Optional<ImageView> save(ImageCreateView image) {
    return mapper.toOptionalView(Optional.of(repository.save(mapper.create(image))));
  }


  public List<Image> matchPictureToMeta(List<Metadata> metadaten){
   return metadaten.stream().map((Metadata a) -> a.getPicture()).toList();
  }




}
