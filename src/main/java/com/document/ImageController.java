package com.document;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.document.view.ImageCreateView;
import com.document.view.ImageUpdateView;
import com.document.view.ImageView;

@RestController

public class ImageController {

  @Autowired
  private ImageService service;

 @GetMapping("image")
  public ResponseEntity<List<Optional<ImageView>>> getList(
      @RequestParam(required = false)String uuid,
      @RequestParam(required = false)String pathname,
      @RequestParam(required = false)String name,
      @RequestParam(required = false)String typ
      ) {
       return ResponseEntity.ok(service.getList(uuid, pathname, name, typ));
  }

 @GetMapping("image/{uuid}")
 public ResponseEntity<ImageView> get(
     @PathVariable String uuid){
   return service.get(uuid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
 }

 @DeleteMapping("image/{uuid}")
 public @ResponseBody ResponseEntity<Optional<ImageView>> delete(
     @PathVariable String uuid){
  return ResponseEntity.ok(service.delete(uuid));
 }


 @PutMapping("image/{uuid}")
 public ResponseEntity<Optional<ImageView>> update(
     @PathVariable String uuid,
     @RequestBody ImageUpdateView updateView)
 {
   return ResponseEntity.ok(service.update(updateView, uuid));
 }

 @PostMapping(value ="image", consumes = "application/json", produces = "application/json")
 public ResponseEntity<Optional<ImageView>> create(
     @RequestBody ImageCreateView createView
     )
 {
   return ResponseEntity.ok(service.save(createView));
 }

}
