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
import com.user.view.UserDetailView;
import com.user.view.UserView;
import com.userGroup.view.UserGroupView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
public class UserController {

  @Autowired
  private UserService service;
  
  @Autowired UserUsergroupService userUserGroupService;

  @GetMapping(path = "user")
  public ResponseEntity<List<Optional<UserView>>> getList(
      @RequestParam(name= "uuid", required = false)String uuid,
      @RequestParam(name = "name",required = false)String name,
      @RequestParam(name = "password", required = false)String password
      )
  {
   return ResponseEntity.ok(service.getList(uuid, name, password));
  }

  @GetMapping(value = "user/{uuid}")
  public ResponseEntity<Optional<UserDetailView>> get(
      @PathVariable("uuid") String uuid)
  {
    return ResponseEntity.ok(service.getDetailView(uuid));

  }
  
  @GetMapping("user/{uuid}/usergroups")
  public ResponseEntity<Optional<List<UserGroupView>>> getFittingUserGroups(
      @PathVariable("uuid") String uuid)
  {
    return ResponseEntity.ok(service.getUserAssociatedUserGroups(uuid));
  }
  
  @GetMapping(value = "userCon")
  public ResponseEntity<List<Optional<UserView>>> getContaining(
      @RequestParam(name = "name",required = true)String name)
  {
    return ResponseEntity.ok(service.findContaining(name));
  }
  
  @GetMapping(path = "userDetail")
  public ResponseEntity<Optional<UserDetailView>> getDetails(
    @RequestParam(name="uuid", required= true)String uuid
    )
    {
      return ResponseEntity.ok(service.getDetailView(uuid));
    }

  @PostMapping(value ="user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Optional<UserView>> create(
        @RequestBody UserDetailView detailView
        )
    {
       return ResponseEntity.ok(service.save(detailView));
    }
  
  @PutMapping("/user/{uuid}/usergroups2")
  public ResponseEntity<Optional<UserView>> updateUserGroups(
      @PathVariable("uuid") String uuid,
      @RequestBody List<String> groupIds) {

      return ResponseEntity.ok(userUserGroupService.updateAssociatedUserGroups(uuid, groupIds));
  }

  @PutMapping("user/{uuid}")
  public ResponseEntity<Optional<UserView>> update(
      @PathVariable("uuid") String uuid,
      @RequestBody UserDetailView detailView
      )
  {
    return ResponseEntity.ok(service.update(detailView, uuid));
  }

  @DeleteMapping("user/{uuid}")
  public ResponseEntity<Optional<UserView>> delete(
      @PathVariable ("uuid") String uuid)
  {
    return ResponseEntity.ok(service.delete(uuid));
  }


}
