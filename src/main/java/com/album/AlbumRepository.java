package com.album;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.album.model.Album;

public interface AlbumRepository extends CrudRepository<Album, String>, FilteredAlbumRepository{


  @Override
  List<Album> findAll();

}
