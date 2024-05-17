package com.album;

import java.util.Optional;
import org.mapstruct.Mapper;
import com.album.model.Album;
import com.album.view.AlbumCreateView;
import com.album.view.AlbumUpdateView;
import com.album.view.AlbumView;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

  public default Optional<AlbumView> toOptionalView(Optional<Album> album){return album.map(this::toView);}
  AlbumView toView(Album album);
  public default Optional<Album> fromOptionalView(Optional<AlbumView> view){return view.map(this::fromView);}
  Album fromView(AlbumView view);
  public default Optional<Album> updateOptional(Optional<AlbumUpdateView> updateView){return updateView.map(this::update);}
  Album update(AlbumUpdateView updateView);
  public default Optional<Album> createOptional(Optional<AlbumCreateView> createView){return createView.map(this::create);}
  Album create(AlbumCreateView createView);
}
