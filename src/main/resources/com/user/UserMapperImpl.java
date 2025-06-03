package com.user;

import com.album.model.Album;
import com.person.model.Person;
import com.user.model.User;
import com.user.view.UserCreateView;
import com.user.view.UserDetailView;
import com.user.view.UserUpdateView;
import com.user.view.UserView;
import com.userGroup.model.UserGroup;
import com.userGroup.view.UserGroupView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-24T15:20:27+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserView toView(User user) {
        if ( user == null ) {
            return null;
        }

        UserView userView = new UserView();

        userView.setUuid( user.getUuid() );
        userView.setName( user.getName() );

        return userView;
    }

    @Override
    public User fromView(UserView view) {
        if ( view == null ) {
            return null;
        }

        User user = new User();

        user.setUuid( view.getUuid() );
        user.setName( view.getName() );

        return user;
    }

    @Override
    public User create(UserCreateView createView) {
        if ( createView == null ) {
            return null;
        }

        User user = new User();

        user.setUuid( createView.getUuid() );
        user.setName( createView.getName() );
        user.setPassword( createView.getPassword() );
        user.setPerson( createView.getPerson() );

        return user;
    }

    @Override
    public User update(UserUpdateView updateVew) {
        if ( updateVew == null ) {
            return null;
        }

        User user = new User();

        user.setName( updateVew.getName() );
        user.setPassword( updateVew.getPassword() );
        List<UserGroup> list = updateVew.getUserGroups();
        if ( list != null ) {
            user.setUserGroups( new ArrayList<UserGroup>( list ) );
        }
        user.setPerson( updateVew.getPerson() );

        return user;
    }

    @Override
    public UserDetailView toUserDetailView(User user) {
        if ( user == null) {
            return null;
        }

        UserDetailView userDetailView = new UserDetailView();
        userDetailView.setUuid(user.getUuid());
        userDetailView.setName(user.getName());
        userDetailView.setVorname(user.getPerson().getVorname());
        userDetailView.setNachname(user.getPerson().getNachname());
        userDetailView.setEmail(user.getPerson().getEmail());
        
        List<UserGroupView> newList = user.getUserGroups().stream()
            .map(a -> new UserGroupView(a.getUuid(), a.getName(), a.getUser()))
            .collect(Collectors.toList());

        userDetailView.setUserGroups(newList);
        

        return userDetailView;
    }
    
    @Override
    public User fromUserDetailView(UserDetailView userdetailview) {
      if (userdetailview == null) {
        return null;
      }
      
      User user = new User();
      Person person = new Person();
      user.setPerson(person);
      user.setUuid(userdetailview.getUuid());
      user.setName(userdetailview.getName());
      user.getPerson().setUuid(userdetailview.getUuid());
      user.getPerson().setVorname(userdetailview.getVorname());
      user.getPerson().setNachname(userdetailview.getNachname());
      user.getPerson().setEmail(userdetailview.getEmail());
      user.setUserGroups(user.getUserGroups());
      
      return user;
    }
    
    @Override
    public UserGroupView toUserGroupView(UserGroup userGroup) {
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
    UserGroupView userGroupView = new UserGroupView( uuid, name, user);

    return userGroupView;
    }
}
