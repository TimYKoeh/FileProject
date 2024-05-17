package com.document;

import java.util.Optional;
import org.mapstruct.Mapper;
import com.document.model.Image;
import com.document.view.ImageCreateView;
import com.document.view.ImageUpdateView;
import com.document.view.ImageView;

@Mapper(componentModel = "spring")
public interface ImageMapper {

  public default Optional<ImageView> toOptionalView(Optional<Image> image){return image.map(this::toView);}
  public ImageView toView(Image image);
  public default Optional<Image> fromOptionalView(Optional<ImageView> view){return view.map(this::fromView);}
  public Image fromView(ImageView view);
  public Image update(ImageUpdateView updateView);
  public Image create(ImageCreateView createView);
}
