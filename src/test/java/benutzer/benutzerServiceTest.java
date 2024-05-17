package benutzer;
/*
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import com.Main;
import com.user.UserService;
import com.user.UserToViewMapper;
import com.user.model.Person;
import com.user.model.User;
import com.user.view.UserUpdateView;
import com.user.view.PersonView;
import com.user.view.UserView;

@SpringBootTest(classes = Main.class)
@AutoConfigureTestEntityManager
@TestPropertySource( locations = "classpath:test-application.properties")
public class benutzerServiceTest {


  @Autowired
  private UserService benutzerService;
  @Autowired
  private TestEntityManager entityManager;
  @Autowired
  private UserToViewMapper viewMapper;

  @Test
  @Transactional
  public void testGetBenutzerAndPersonByName() {

    //Setup
    Person personIn = new Person("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Peter", "Parker", "Spiderman@gmail.com");
    User benutzerIn = new User("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Parker", "MaryJane", null ,personIn);
    entityManager.persist(benutzerIn);
    entityManager.persist(personIn);
    entityManager.flush();

    //Execute
    List<UserView> benutzerNachName = benutzerService.getViewList(null, "Parker", null);
    //List<PersonView> personNachName = benutzerService.getPersonViewList(null, "Parker", null);

    UserView benutzerViewNachName = benutzerNachName.get(0);
    //PersonView personViewNachName = personNachName.get(0);

    //Assert
    assertThat(benutzerViewNachName.getUuid()).isEqualTo(benutzerIn.getUuid());
    //assertThat(personViewNachName.getBenutzer_id()).isEqualTo(personIn.getUuid());
  }

  @Test
  @Transactional
  public void testGetAllBenutzer() {

    //Setup
    Person person1 = new Person("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Peter", "Parker", "Spiderman@gmail.com");
    Person person2 = new Person("875bcece-ae4e-4a8a-9b0d-4deb2ec0e841", "Mary-Jane", "Watson", "Watson@acor.de");
    Person person3 = new Person("984bccee-ae4e-4a8a-9b0d-4deb2ec0e841", "Willam", "Dafoe", "GreenGoblin@gmail.com");

    User benutzer1 = new User("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Parker", "MaryJane", null ,person1);
    User benutzer2 = new User("875bcece-ae4e-4a8a-9b0d-4deb2ec0e841", "Watson", "PeterP", null ,person2);
    User benutzer3 = new User("984bccee-ae4e-4a8a-9b0d-4deb2ec0e841", "Dafoe", "Lighthouse", null ,person3);

    List<User> benutzerList = new LinkedList<>();
    benutzerList.addAll(Arrays.asList(benutzer1, benutzer2, benutzer3));

    entityManager.persist(benutzer1);
    entityManager.persist(benutzer2);
    entityManager.persist(benutzer3);

    entityManager.persist(person1);
    entityManager.persist(person2);
    entityManager.persist(person3);

    entityManager.flush();

    //Execute
    List<UserView> benutzerViewList = benutzerList.stream().map((User c) -> viewMapper.toView(c)).toList();

    //Assert
    benutzerViewList.stream().forEach((a) -> assertThat(benutzerService.getAllUserViewAsList().contains(a)));
  }

  @Test
  @Transactional
  public void testUpdateBenutzer() {

    //Setup
    Person person1 = new Person("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Peter", "Parker", "Spiderman@gmail.com");
    User benutzer1 = new User("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Parker", "MaryJane", null ,person1);
    String updateName = "Porker";
    UserUpdateView benutzer1Update = new UserUpdateView("Peter", updateName, "Spiderman@gmail.com", "MaryJane", null, person1);
    entityManager.persist(benutzer1);
    entityManager.persist(person1);
    entityManager.flush();

    //Execute
    benutzerService.updateUser(benutzer1Update, benutzer1.getUuid());

    //Assert
    assertThat(benutzerService.getUserView(benutzer1.getUuid()).getName()).isEqualTo(updateName);
  }

  @Test
  @Transactional
  public void testDeleteBenutzer() {

    //Setup
    Person person1 = new Person("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Peter", "Parker", "Spiderman@gmail.com");
    User benutzer1 = new User("875cbcee-ae4e-4a8a-9b0d-4deb2ec0e841", "Parker", "MaryJane", null ,person1);
    entityManager.persist(benutzer1);
    entityManager.persist(person1);
    entityManager.flush();
    assertNotNull(benutzer1.getUuid());

    //Execute
    benutzerService.deleteUser(benutzer1.getUuid());

    //Assert

  }
}
*/