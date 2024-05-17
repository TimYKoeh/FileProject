package com.person;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.person.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilteredPersonRepositoryImpl implements FilteredPersonRepository {

  @Autowired
  EntityManager entitymanager;

  @Override
  public List<Person> getFilteredList(String uuid, String firstName, String surname, String email) {
    CriteriaBuilder criteriabuilder = entitymanager.getCriteriaBuilder();
    CriteriaQuery<Person> criteriaquery = criteriabuilder.createQuery(Person.class);

    Root<Person> person = criteriaquery.from(Person.class);
    List<Predicate> predicates = new LinkedList<>();

    if(uuid != null) {
      predicates.add(criteriabuilder.equal(person.get("uuid"), uuid));
    }else if(firstName != null) {
      predicates.add(criteriabuilder.equal(person.get("name"), firstName));
    }else if(surname != null) {
      predicates.add(criteriabuilder.equal(person.get("name"), surname));
    }else if(email != null) {
      predicates.add(criteriabuilder.equal(person.get("name"), email));
    }

    criteriaquery.where(predicates.toArray(new Predicate[0]));
    return entitymanager.createQuery(criteriaquery).getResultList();
  }

}
