package com.userGroup;

import java.util.Optional;
import org.mapstruct.Mapper;
import com.userGroup.model.UserGroup;
import com.userGroup.view.UserGroupCreateView;
import com.userGroup.view.UserGroupUpdateView;
import com.userGroup.view.UserGroupView;

@Mapper(componentModel = "spring")
public interface UserGroupMapper {

  public default Optional<UserGroupView> toOptionalView(Optional<UserGroup> userGroup){return userGroup.map(this::toView);}
  public UserGroupView toView(UserGroup userGroup);
  public default Optional<UserGroup> fromOptionalView(Optional<UserGroupView> view){return view.map(this::fromView);}
  public UserGroup fromView(UserGroupView view);
  public UserGroup update(UserGroupUpdateView updateView);
  public UserGroup create(UserGroupCreateView createView);
}
