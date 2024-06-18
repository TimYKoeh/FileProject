package com.user;

import com.person.model.Person;
import com.user.model.User;
import com.user.view.UserCreateView;
import com.user.view.UserDetailView;
import com.user.view.UserUpdateView;
import com.user.view.UserView;
import com.userGroup.model.UserGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public UserDetailView detailed(Optional<User> user, Optional<Person> person) {
        if ( user == null && person == null ) {
            return null;
        }

        UserDetailView userDetailView = new UserDetailView();

        return userDetailView;
    }
}
