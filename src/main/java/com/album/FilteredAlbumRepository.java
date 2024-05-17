package com.album;

import java.util.List;
import com.album.model.Album;

public interface FilteredAlbumRepository {

  public List<Album> getFilteredList(String name);
}
