package com.person;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.person.model.Person;
import com.person.view.PersonCreateView;
import com.person.view.PersonUpdateView;
import com.person.view.PersonView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;
  @Autowired
  private PersonMapper mapper;

  public List<Optional<PersonView>> getList(String uuid, String firstName, String surname, String email){
    return repository.getFilteredList(uuid, firstName, surname, email).stream().map((Person person) -> mapper.toOptionalView(Optional.of(person))).toList();
  }

  public Optional<PersonView> get(String uuid){
    return mapper.toOptionalView(repository.findById(uuid));
  }


  public Optional<PersonView> update(PersonUpdateView personUpdated, String uuid) {
    return mapper
        .toOptionalView(repository.findById(uuid)
            .map(person -> {
      Person updatedAlbum = keepPreviousRelations(mapper.update(personUpdated), person);
      updatedAlbum.setUuid(uuid);

      repository.save(updatedAlbum);
      return updatedAlbum;
    }));
  }

  private Person keepPreviousRelations(Person mappedPerson, Person savedPerson) {
    if(mappedPerson.getUser() == null) {
      mappedPerson.setUser(savedPerson.getUser());
    }
    return mappedPerson;
  }

  public Optional<PersonView> delete(String uuid) {
    Optional<Person> optionalPerson = repository.findById(uuid);

    optionalPerson.ifPresent(person -> {
      Hibernate.initialize(person.getUser());
      repository.delete(person);
    });
    return mapper.toOptionalView(optionalPerson);
  }

  public Optional<PersonView> save(PersonCreateView person) {
    return mapper.toOptionalView(Optional.of(repository.save(mapper.create(person))));
  }

}
