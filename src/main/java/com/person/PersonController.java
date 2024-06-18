package com.person;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.person.view.PersonCreateView;
import com.person.view.PersonUpdateView;
import com.person.view.PersonView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonController {
  @Autowired
  private PersonService service;

  @GetMapping("person")
  public ResponseEntity<List<Optional<PersonView>>> getList(
      @RequestParam(name="uuid", required = false) String uuid,
      @RequestParam(name="firstName", required = false) String firstName,
      @RequestParam(name="surname", required = false) String surname,
      @RequestParam(name="email", required = false) String email) {
    return ResponseEntity.ok(service.getList(uuid, firstName, surname, email));
  }

  @GetMapping("person/{uuid}")
  public ResponseEntity<PersonView> get(
      @PathVariable String uuid)
  {
    return service.get(uuid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

  }

  @DeleteMapping("person/{uuid}")
  public ResponseEntity<Optional<PersonView>> delete(
      @PathVariable String uuid)
  {
    return ResponseEntity.ok(service.delete(uuid));
  }


  @PutMapping("person/{uuid}")
  public ResponseEntity<Optional<PersonView>> update(
      @PathVariable String uuid,
      @RequestBody PersonUpdateView updateView
      )
  {
    return ResponseEntity.ok(service.update(updateView, uuid));
  }

  @PostMapping(value ="person", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Optional<PersonView>> create(
      @RequestBody PersonCreateView createView
      )
  {
     return ResponseEntity.ok(service.save(createView));
  }
}
