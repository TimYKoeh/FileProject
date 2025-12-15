package com.album;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.album.model.Album;
import com.album.view.AlbumCreateView;
import com.album.view.AlbumUpdateView;
import com.album.view.AlbumView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class AlbumService {

  @Autowired
  private AlbumRepository repository;
  @Autowired
  private AlbumMapper mapper;


  public List<AlbumView> getList(String name){
    return repository.getFilteredList(name).stream().map((Album album) -> mapper.toView(album)).toList();
  }

  public Optional<AlbumView> get(String uuid){
    return mapper.toOptionalView(repository.findById(uuid));
  }

  public Optional<AlbumView> update(AlbumUpdateView albumUpdated, String uuid) {
    return mapper
        .toOptionalView(repository.findById(uuid)
            .map(album -> {
      Album updatedAlbum = keepPreviousRelations(mapper.update(albumUpdated), album);
      updatedAlbum.setUuid(uuid);

      repository.save(updatedAlbum);
      return updatedAlbum;
    }));


  }

  private Album keepPreviousRelations(Album mappedAlbum, Album savedAlbum) {
    if(mappedAlbum.getPictures() == null) {
      mappedAlbum.setPictures(savedAlbum.getPictures());
    }
    if(mappedAlbum.getUserGroups() == null) {
      mappedAlbum.setUserGroups(savedAlbum.getUserGroups());
    }
    return mappedAlbum;
  }

  public Optional<AlbumView> delete(String uuid) {
    Optional<Album> optionalAlbum = repository.findById(uuid);

    if (optionalAlbum.isPresent()) {
        Album album = optionalAlbum.get();

        try {
            if (album.getUserGroups() != null) {
                Hibernate.initialize(album.getUserGroups());
                album.getUserGroups().clear();
            }

            if (album.getPictures() != null) {
                Hibernate.initialize(album.getPictures());

                album.getPictures().clear();
            }

            repository.delete(album);
            System.out.println("Album deleted successfully: " + album.getUuid());

        } catch (Exception e) {
            System.err.println("Error deleting album " + uuid + ": " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Could not delete album: " + uuid, e);
        }
    } else {
        System.out.println("Album not found: " + uuid);
    }

    return mapper.toOptionalView(optionalAlbum);
}



  public Optional<AlbumView> save(AlbumCreateView album) {
    return mapper.toOptionalView(Optional.of(repository.save(mapper.create(album))));
  }
}
