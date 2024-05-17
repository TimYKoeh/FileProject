package com.userGroup;

import java.util.List;
import com.userGroup.model.UserGroup;

public interface FilteredUserGroupRepository {

  public List<UserGroup> getFilteredList(String uuid, String name);
}
