package com.userGroup;

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
import com.userGroup.view.UserGroupCreateView;
import com.userGroup.view.UserGroupUpdateView;
import com.userGroup.view.UserGroupView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserGroupController {

  @Autowired
  private UserGroupService service;

  @GetMapping(path = "user_groups")
  public ResponseEntity<List<Optional<UserGroupView>>> getList(
      @RequestParam(required = false) String uuid,
      @RequestParam(required = false) String name) {
    return ResponseEntity.ok(service.getList(uuid, name));
  }

  @GetMapping("user_groups/{uuid}")
  public ResponseEntity<UserGroupView> get(
      @PathVariable String uuid)
  {
    return service.get(uuid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

  }

  @PutMapping("user_groups/{uuid}")
  public ResponseEntity<Optional<UserGroupView>> update(
      @PathVariable String uuid,
      @RequestBody UserGroupUpdateView updateView
      )
  {
    return ResponseEntity.ok(service.update(updateView, uuid));
  }

  @DeleteMapping("user_groups/{uuid}")
  public ResponseEntity<Optional<UserGroupView>> delete(
      @PathVariable String uuid)
  {
    return ResponseEntity.ok(service.delete(uuid));
  }

  @PostMapping(value ="user_groups", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Optional<UserGroupView>> create(
        @RequestBody UserGroupCreateView createView
        )
    {
      return ResponseEntity.ok(service.save(createView));
    }
}
