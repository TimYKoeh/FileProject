package com.person;

import com.person.model.Person;
import com.person.view.PersonCreateView;
import com.person.view.PersonUpdateView;
import com.person.view.PersonView;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-24T15:20:27+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonView toView(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonView personView = new PersonView();

        personView.setUuid( person.getUuid() );
        personView.setFirstName( person.getFirstName() );
        personView.setSurname( person.getSurname() );
        personView.setEmail( person.getEmail() );

        return personView;
    }

    @Override
    public Person fromView(PersonView view) {
        if ( view == null ) {
            return null;
        }

        Person person = new Person();

        person.setUuid( view.getUuid() );
        person.setFirstName( view.getFirstName() );
        person.setSurname( view.getSurname() );
        person.setEmail( view.getEmail() );

        return person;
    }

    @Override
    public Person update(PersonUpdateView updateView) {
        if ( updateView == null ) {
            return null;
        }

        Person person = new Person();

        person.setUser( updateView.getUser() );
        person.setFirstName( updateView.getFirstName() );
        person.setSurname( updateView.getSurname() );
        person.setEmail( updateView.getEmail() );

        return person;
    }

    @Override
    public Person create(PersonCreateView createView) {
        if ( createView == null ) {
            return null;
        }

        Person person = new Person();

        person.setUuid( createView.getUuid() );
        person.setUser( createView.getUser() );
        person.setFirstName( createView.getFirstName() );
        person.setSurname( createView.getSurname() );
        person.setEmail( createView.getEmail() );

        return person;
    }
}
