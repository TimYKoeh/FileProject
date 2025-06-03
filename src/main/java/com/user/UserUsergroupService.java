package com.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.model.User;
import com.user.view.UserView;
import com.userGroup.UserGroupRepository;
import com.userGroup.model.UserGroup;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
public class UserUsergroupService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserGroupRepository usergroupRepository;
  @Autowired
  public UserMapper userMapper;

  
  
  
  public Optional<UserView> updateAssociatedUserGroups(String uuid, List<String> newGroupIds) {
    User user = userRepository.findById(uuid)
        .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + uuid));


    List<UserGroup> currentGroups = user.getUserGroups().stream().filter(group -> newGroupIds.contains(group.getUuid())).toList();
    //currentGroups.removeIf(group ->!newGroupIds.contains(group.getUuid()));
    
    
    List<UserGroup> newGroups = newGroupIds.stream()
        .map(groupId -> usergroupRepository.findById(groupId)
            .orElseThrow(() -> new IllegalArgumentException("UserGroup not found: " + groupId)))
        .toList();
  

  currentGroups.addAll(newGroups);
  User savedUser = user;
  savedUser.setUserGroups(currentGroups);
  savedUser = userRepository.save(user);
  return userMapper.toOptionalView(Optional.of(savedUser));
  }

}
  
  
  

