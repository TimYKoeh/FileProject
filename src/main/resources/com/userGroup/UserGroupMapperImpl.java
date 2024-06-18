package com.userGroup;

import com.album.model.Album;
import com.user.model.User;
import com.userGroup.model.UserGroup;
import com.userGroup.view.UserGroupCreateView;
import com.userGroup.view.UserGroupUpdateView;
import com.userGroup.view.UserGroupView;
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
public class UserGroupMapperImpl implements UserGroupMapper {

    @Override
    public UserGroupView toView(UserGroup userGroup) {
        if ( userGroup == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        List<User> user = null;
        List<Album> albums = null;

        uuid = userGroup.getUuid();
        name = userGroup.getName();
        List<User> list = userGroup.getUser();
        if ( list != null ) {
            user = new ArrayList<User>( list );
        }
        List<Album> list1 = userGroup.getAlbums();
        if ( list1 != null ) {
            albums = new ArrayList<Album>( list1 );
        }

        UserGroupView userGroupView = new UserGroupView( uuid, name, user, albums );

        return userGroupView;
    }

    @Override
    public UserGroup fromView(UserGroupView view) {
        if ( view == null ) {
            return null;
        }

        UserGroup userGroup = new UserGroup();

        userGroup.setUuid( view.getUuid() );
        userGroup.setName( view.getName() );

        return userGroup;
    }

    @Override
    public UserGroup update(UserGroupUpdateView updateView) {
        if ( updateView == null ) {
            return null;
        }

        UserGroup userGroup = new UserGroup();

        userGroup.setName( updateView.getName() );
        List<User> list = updateView.getUser();
        if ( list != null ) {
            userGroup.setUser( new ArrayList<User>( list ) );
        }
        List<Album> list1 = updateView.getAlbums();
        if ( list1 != null ) {
            userGroup.setAlbums( new ArrayList<Album>( list1 ) );
        }

        return userGroup;
    }

    @Override
    public UserGroup create(UserGroupCreateView createView) {
        if ( createView == null ) {
            return null;
        }

        UserGroup userGroup = new UserGroup();

        userGroup.setUuid( createView.getUuid() );
        userGroup.setName( createView.getName() );
        List<User> list = createView.getUser();
        if ( list != null ) {
            userGroup.setUser( new ArrayList<User>( list ) );
        }
        List<Album> list1 = createView.getAlbums();
        if ( list1 != null ) {
            userGroup.setAlbums( new ArrayList<Album>( list1 ) );
        }

        return userGroup;
    }
}
