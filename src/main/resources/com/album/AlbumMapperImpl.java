package com.album;

import com.album.model.Album;
import com.album.view.AlbumCreateView;
import com.album.view.AlbumUpdateView;
import com.album.view.AlbumView;
import com.document.model.Image;
import com.userGroup.model.UserGroup;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-24T15:20:27+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class AlbumMapperImpl implements AlbumMapper {

    @Override
    public AlbumView toView(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumView albumView = new AlbumView();

        albumView.setUuid( album.getUuid() );
        albumView.setName( album.getName() );
        List<Image> list = album.getPictures();
        if ( list != null ) {
            albumView.setPictures( new ArrayList<Image>( list ) );
        }

        return albumView;
    }

    @Override
    public Album fromView(AlbumView view) {
        if ( view == null ) {
            return null;
        }

        Album album = new Album();

        album.setName( view.getName() );
        List<Image> list = view.getPictures();
        if ( list != null ) {
            album.setPictures( new ArrayList<Image>( list ) );
        }
        album.setUuid( view.getUuid() );

        return album;
    }

    @Override
    public Album update(AlbumUpdateView updateView) {
        if ( updateView == null ) {
            return null;
        }

        Album album = new Album();

        album.setName( updateView.getName() );
        List<UserGroup> list = updateView.getUserGroups();
        if ( list != null ) {
            album.setUserGroups( new ArrayList<UserGroup>( list ) );
        }
        List<Image> list1 = updateView.getPictures();
        if ( list1 != null ) {
            album.setPictures( new ArrayList<Image>( list1 ) );
        }

        return album;
    }

    @Override
    public Album create(AlbumCreateView createView) {
        if ( createView == null ) {
            return null;
        }

        Album album = new Album();

        album.setName( createView.getName() );
        List<UserGroup> list = createView.getUserGroups();
        if ( list != null ) {
            album.setUserGroups( new ArrayList<UserGroup>( list ) );
        }
        List<Image> list1 = createView.getPictures();
        if ( list1 != null ) {
            album.setPictures( new ArrayList<Image>( list1 ) );
        }
        album.setUuid( createView.getUuid() );

        return album;
    }
}
