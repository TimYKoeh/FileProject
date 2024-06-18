package com.album;

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
import com.album.view.AlbumCreateView;
import com.album.view.AlbumUpdateView;
import com.album.view.AlbumView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AlbumController {

  @Autowired
  private AlbumService service;

  @GetMapping("album")
  public ResponseEntity<List<AlbumView>> getList(
      @RequestParam(name="name", required = false) String name) {
    return ResponseEntity.ok(service.getList(name));
  }

  @GetMapping("album/{uuid}")
  public ResponseEntity<AlbumView> get(
      @PathVariable String uuid)
  {
    return service.get(uuid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

  }


  @DeleteMapping("album/{uuid}")
  public ResponseEntity<Optional<AlbumView>> delete(
      @PathVariable String uuid)
  {
    return ResponseEntity.ok(service.delete(uuid));
  }


  @PutMapping("album/{uuid}")
  public ResponseEntity<Optional<AlbumView>> update(
      @PathVariable String uuid,
      @RequestBody AlbumUpdateView updateView
      )
  {
    return ResponseEntity.ok(service.update(updateView, uuid));
  }

  @PostMapping(value ="album", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Optional<AlbumView>> create(
      @RequestBody AlbumCreateView createView
      )
  {
     return ResponseEntity.ok(service.save(createView));
  }
}
