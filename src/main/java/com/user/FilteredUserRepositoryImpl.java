package com.user;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.user.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilteredUserRepositoryImpl implements FilteredUserRepository{

  @Autowired
  EntityManager entitymanager;

  @Override
  public List<User> getUserList(String uuid, String name, String password) {
    CriteriaBuilder criteriabuilder = entitymanager.getCriteriaBuilder();
    CriteriaQuery<User> criteriaquery = criteriabuilder.createQuery(User.class);

    Root<User> user = criteriaquery.from(User.class);
    List<Predicate> predicates = new LinkedList<>();

    if(uuid != null) {
      predicates.add(criteriabuilder.equal(user.get("uuid"), uuid));
    }else if(name != null) {
      predicates.add(criteriabuilder.equal(user.get("name"), name));
    }else if(password != null) {
      predicates.add(criteriabuilder.equal(user.get("password"), password));
    }
    criteriaquery.where(predicates.toArray(new Predicate[0]));
    return entitymanager.createQuery(criteriaquery).getResultList();
  }
}
