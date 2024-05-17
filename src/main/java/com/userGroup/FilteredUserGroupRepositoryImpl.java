package com.userGroup;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.userGroup.model.UserGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilteredUserGroupRepositoryImpl implements FilteredUserGroupRepository{

  @Autowired
  EntityManager entitymanager;

  @Override
  public List<UserGroup> getFilteredList(String uuid, String name) {
    CriteriaBuilder criteriabuilder = entitymanager.getCriteriaBuilder();
    CriteriaQuery<UserGroup> criteriaquery = criteriabuilder.createQuery(UserGroup.class);

    Root<UserGroup> userGroup = criteriaquery.from(UserGroup.class);
    List<Predicate> predicates = new LinkedList<>();

    if(uuid != null) {
      predicates.add(criteriabuilder.equal(userGroup.get("uuid"), uuid));
    }else if(name != null) {
      predicates.add(criteriabuilder.equal(userGroup.get("name"), name));
    }
    criteriaquery.where(predicates.toArray(new Predicate[0]));
    return entitymanager.createQuery(criteriaquery).getResultList();
  }

}
