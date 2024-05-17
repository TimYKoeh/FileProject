package com.document;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.document.model.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

class FilteredImageRepositoryImpl implements FilteredImageRepository{

  @Autowired
  EntityManager entitymanager;


  @Override
  public List<Image> getFilteredList(String uuid, String pathname, String name, String typ) {


    CriteriaBuilder criteriabuilder = entitymanager.getCriteriaBuilder();
    CriteriaQuery<Image> criteriaquery = criteriabuilder.createQuery(Image.class);

    Root<Image> bild = criteriaquery.from(Image.class);
    List<Predicate> predicates = new LinkedList<>();
        if(uuid != null) {
          predicates.add(criteriabuilder.equal(bild.get("uuid"), uuid));
        }
        if(pathname != null) {
          predicates.add(criteriabuilder.equal(bild.get("pathname"), pathname));
        }
        if(name != null) {
          predicates.add(criteriabuilder.equal(bild.get("name"), name));
        }
        if(typ != null) {
          predicates.add(criteriabuilder.equal(bild.get("typ"), typ));
        }
        criteriaquery.where(predicates.toArray(new Predicate[0]));
        return entitymanager.createQuery(criteriaquery).getResultList();

  }

}
