/*package album;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import com.Main;
import com.album.AlbumController;
import com.album.AlbumMapper;
import com.album.AlbumService;
import com.album.model.Album;
import com.album.view.AlbumCreateView;
import com.album.view.AlbumUpdateView;
import com.album.view.AlbumView;
import com.document.model.Image;
import com.userGroup.model.UserGroup;

@SpringBootTest(classes = Main.class)
@AutoConfigureTestEntityManager
@TestPropertySource( locations = "classpath:test-application.properties")
public class AlbumControllerTest {

  private static String EXISTING_ENTITY_ID = "875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841";
  private static String NOT_EXISTING_ENTITY_ID = "875cbcee-ae4e-488a-9b0d-4deb2ec0e841";
  private static String EXISTING_ENTITY_NAME = "Album";
  private static String NOT_EXISTING_ENTITY_NAME = "NichtAlbum";
  private static String PATCHED_ENTITY_NAME = "patched";

  @Autowired
  private AlbumController sut;
  @Autowired
  private TestEntityManager entityManager;

  Album album;

  @BeforeEach
  public void createData() {
    album = new Album(EXISTING_ENTITY_ID, EXISTING_ENTITY_NAME);
    entityManager.persist(album);
    entityManager.flush();
  }

  @Test
  @Transactional
  public void testGet() {
    //Setup
    AlbumView expectedResult = new AlbumView(EXISTING_ENTITY_ID,EXISTING_ENTITY_NAME, new LinkedList<Image>());
    //Execute
    ResponseEntity<AlbumView> responseEntity = sut.get(EXISTING_ENTITY_ID);
    //Assert
    assertStatusCodeOk(responseEntity);
    assertThat(responseEntity.getBody()).usingRecursiveComparison().isEqualTo(expectedResult);
  }

  @Test
  @Transactional
  public void testGetNotFound() {
      ResponseEntity<AlbumView> responseEntity = sut.get(NOT_EXISTING_ENTITY_ID);
      assertStatusCodeNotFound(responseEntity);
  }

  @Test
  @Transactional
  public void testGetList() {
    //Setup
    ResponseEntity<List<AlbumView>> responseEntity = sut.getList(EXISTING_ENTITY_NAME);
    //Execute
    //Assert
    assertStatusCodeOk(responseEntity);
  }

  @Test
  @Transactional
  public void testDelete() {
    //Setup
    //Execute
    sut.delete(EXISTING_ENTITY_ID);
    //Assert
    assertStatusCodeNotFound(sut.get(EXISTING_ENTITY_ID));
  }

  @Test
  @Transactional
  public void testUpdate() {
    //Setup
    AlbumView expectedResults = new AlbumView(EXISTING_ENTITY_ID, PATCHED_ENTITY_NAME, new LinkedList<Image>());
    AlbumUpdateView updatedEntity = new AlbumUpdateView(PATCHED_ENTITY_NAME, new LinkedList<UserGroup>(), new LinkedList<Image>());
    //Execute
    sut.update(EXISTING_ENTITY_ID, updatedEntity);
    //Assert
    assertThat(sut.get(EXISTING_ENTITY_ID).getBody()).usingRecursiveComparison().isEqualTo(expectedResults);
  }

  @Test
  @Transactional
  public void testCreate() {
    //Setup
    AlbumCreateView entityToCreate = new AlbumCreateView(NOT_EXISTING_ENTITY_NAME, new LinkedList<UserGroup>(), new LinkedList<Image>());
    String entityUuid = entityToCreate.getUuid();
    //Execute
    sut.create(entityToCreate);
    //Assert
    assertStatusCodeOk(sut.get(entityUuid));
  }

  private void assertStatusCodeOk(ResponseEntity<?> responseEntity) {
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  private void assertStatusCodeNotFound(ResponseEntity<?> responseEntity) {
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

}
*/