package datei;
/*

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class DateiServiceTest {


  List<LinkedList<Datei>> listenListe = new ArrayList<>();
  Bild dateiIn = new Bild(UUID.randomUUID().toString(), "Hallo//newfile", null, null, 0, 0, new BildMetadata(null, null, null, null));
  Bild dateiOut = new Bild(UUID.randomUUID().toString(), null, null, null, 0, 0, new BildMetadata(null, null, null, null));
  LinkedList<Datei> tempList = new LinkedList<>();
  LinkedList<Datei> fullList = new LinkedList<>();
  Map<File, LinkedList<Datei>> map = new HashMap<>();
  File f = new File("Hallo");

  @InjectMocks
  DateiService sut;



  @Mock
  PostgreSqlDao mockedDao;
  List<File> mockedList = Mockito.mock(LinkedList.class);
  Map mockedMap = Mockito.mock(Map.class);


  @BeforeEach
public void emptyTempList() {
  tempList.clear();
  tempList.add(dateiIn);
}

  @Test
  public void testUpdateOrSave() {

    //Setup
    LinkedList<Datei> liste = new LinkedList<>();
    liste.add(dateiIn);
    liste.add(dateiOut);
    listenListe.add(liste);
    when(mockedDao.getAll()).thenReturn(tempList);

    //Execute
//    sut.saveOrUpdate(listenListe);

    //Assert
    liste.stream().skip(1).forEach((a) -> Mockito.verify(mockedDao).save(a));
    Mockito.verify(mockedDao).update(tempList.getFirst());
  }


  @Test
  public void testFindDatei() {

    //Setup
    when(mockedDao.getAll()).thenReturn(tempList);
    when(mockedDao.get(dateiIn.getUuid())).thenReturn(Optional.of(dateiIn));

    //Execute
    sut.findDatei(dateiIn.getUuid());
    sut.findDatei(dateiOut.getUuid());

    //Assert
    Mockito.verify(mockedDao).get(dateiIn.getUuid());
  }

  @Test
  public void testDeleteFromDb() {

    //Setup
    when(mockedDao.getAll()).thenReturn(tempList);

    //Execute
 //   sut.deleteFromDB(dateiIn.getUuid());
 //   sut.deleteFromDB(dateiOut.getUuid());

    //Assert
    Mockito.verify(mockedDao).delete(dateiIn);
  }

  @Test
  public void getListeTest() {

    //Setup
    when(mockedDao.getAll()).thenReturn(tempList);
    when(mockedMap.get(new File(dateiIn.getPathName()).getParentFile())).thenReturn(fullList);

    //Execute
 //   sut.getListe(mockedMap);

    //Assert
    Mockito.verify(mockedMap).get(f);
   }

  @Test
  public void getMapTest() {

    LinkedList<Datei> fileList = new LinkedList<>();
    when(mockedList.stream().collect(toMap(file -> file,b -> new LinkedList<>()))).thenReturn(mockedMap);

    sut.getMap(mockedList);
//    Mockito.verify(mockedMap).size();
  }


}
*/