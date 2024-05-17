package com.album;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.album.model.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilteredAlbumRepositoryImpl implements FilteredAlbumRepository{

  @Autowired
  EntityManager entitymanager;

  @Override
  public List<Album> getFilteredList(String name) {
    CriteriaBuilder criteriabuilder = entitymanager.getCriteriaBuilder();
    CriteriaQuery<Album> criteriaquery = criteriabuilder.createQuery(Album.class);

    Root<Album> album = criteriaquery.from(Album.class);
    List<Predicate> predicates = new LinkedList<>();

    if(name != null) {
      predicates.add(criteriabuilder.equal(album.get("name"), name));
    }

    criteriaquery.where(predicates.toArray(new Predicate[0]));
    return entitymanager.createQuery(criteriaquery).getResultList();

  }

}
