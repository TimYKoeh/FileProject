package com.user;

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
import com.user.view.UserCreateView;
import com.user.view.UserUpdateView;
import com.user.view.UserView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping(path = "user")
  public ResponseEntity<List<Optional<UserView>>> getList(
      @RequestParam(required = false)String uuid,
      @RequestParam(required = false)String name,
      @RequestParam(required = false)String password
      )
  {
   return ResponseEntity.ok(service.getList(uuid, name, password));
  }

  @GetMapping("user/{uuid}")
  public ResponseEntity<UserView> get(
      @PathVariable String uuid)
  {
    return service.get(uuid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

  }

  @PostMapping(value ="user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Optional<UserView>> create(
        @RequestBody UserCreateView createView
        )
    {
       return ResponseEntity.ok(service.save(createView));
    }

  @PutMapping("user/{uuid}")
  public ResponseEntity<Optional<UserView>> update(
      @PathVariable String uuid,
      @RequestBody UserUpdateView updateView
      )
  {
    return ResponseEntity.ok(service.update(updateView, uuid));
  }

  @DeleteMapping("user/{uuid}")
  public ResponseEntity<Optional<UserView>> delete(
      @PathVariable String uuid)
  {
    return ResponseEntity.ok(service.delete(uuid));
  }


}
