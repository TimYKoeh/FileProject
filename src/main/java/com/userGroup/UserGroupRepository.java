package com.userGroup;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.userGroup.model.UserGroup;


public interface UserGroupRepository extends CrudRepository<UserGroup, String>, FilteredUserGroupRepository {

  @Override
  List<UserGroup> findAll();
}
