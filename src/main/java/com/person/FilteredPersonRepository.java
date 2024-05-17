package com.person;

import java.util.List;
import com.person.model.Person;

public interface FilteredPersonRepository {

  List<Person> getFilteredList(String uuid, String firstName, String surname, String email);
}
