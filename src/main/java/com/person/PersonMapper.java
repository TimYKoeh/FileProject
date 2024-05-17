package com.person;

import java.util.Optional;
import org.mapstruct.Mapper;
import com.person.model.Person;
import com.person.view.PersonCreateView;
import com.person.view.PersonUpdateView;
import com.person.view.PersonView;

@Mapper(componentModel = "spring")
public interface PersonMapper {

  public default Optional<PersonView> toOptionalView(Optional<Person> person){return person.map(this::toView);}
  public PersonView toView(Person person);
  public default Optional<Person> fromOptionalView(Optional<PersonView> view){return view.map(this::fromView);}
  public Person fromView(PersonView view);
  public Person update(PersonUpdateView updateView);
  public Person create(PersonCreateView createView);
}
