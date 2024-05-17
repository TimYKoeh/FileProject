package com.userGroup;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userGroup.model.UserGroup;
import com.userGroup.view.UserGroupCreateView;
import com.userGroup.view.UserGroupUpdateView;
import com.userGroup.view.UserGroupView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class UserGroupService {

  @Autowired
  private UserGroupRepository repository;
  @Autowired
  private UserGroupMapper mapper;

  public List<Optional<UserGroupView>> getList(String uuid, String name){
     return repository.getFilteredList(uuid, name).stream().map((UserGroup userGroup) -> mapper.toOptionalView(Optional.of(userGroup))).toList();
  }

  public Optional<UserGroupView> get(String uuid){
    return mapper.toOptionalView(repository.findById(uuid));
  }


  public Optional<UserGroupView> update(UserGroupUpdateView userGroupUpdated, String uuid) {
    return mapper
        .toOptionalView(repository.findById(uuid)
            .map(userGroup -> {
      UserGroup updatedUserGroup = keepPreviousRelations(mapper.update(userGroupUpdated), userGroup);
      updatedUserGroup.setUuid(uuid);

      repository.save(updatedUserGroup);
      return updatedUserGroup;
    }));
  }

  private UserGroup keepPreviousRelations(UserGroup mappedUserGroup, UserGroup savedUserGroup) {
    if(mappedUserGroup.getUser() == null) {
      mappedUserGroup.setUser(savedUserGroup.getUser());
    }
    if(mappedUserGroup.getAlbums() == null) {
      mappedUserGroup.setAlbums(savedUserGroup.getAlbums());
    }
    return mappedUserGroup;
  }

  public Optional<UserGroupView> delete(String uuid) {
    Optional<UserGroup> optionalUserGroup = repository.findById(uuid);

    optionalUserGroup.ifPresent(userGroup -> {
      Hibernate.initialize(userGroup.getUser());
      Hibernate.initialize(userGroup.getAlbums());
      repository.delete(userGroup);
    });
    return mapper.toOptionalView(optionalUserGroup);
  }

  public Optional<UserGroupView> save(UserGroupCreateView createView) {
    return mapper.toOptionalView(Optional.of(repository.save(mapper.create(createView))));
  }

}
