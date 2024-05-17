package com.document;
import java.util.LinkedList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.document.model.Image;



public interface ImageRepository extends CrudRepository<Image, String>, FilteredImageRepository {


 @Override
LinkedList<Image> findAll();

 @Query(value = ":query", nativeQuery = true)
 public List<Image> findByFilter(@Param("query") String query);

 @Query(value= "SELECT * FROM Datei WHERE typ = :typ", nativeQuery = true)
 public List<Image> findByTyp(@Param("typ") String typ);

}
