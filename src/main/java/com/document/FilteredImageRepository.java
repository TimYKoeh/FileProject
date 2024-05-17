package com.document;

import java.util.List;
import com.document.model.Image;

interface FilteredImageRepository {

  public List<Image> getFilteredList(String uuid, String pathname, String name, String typ);

}
