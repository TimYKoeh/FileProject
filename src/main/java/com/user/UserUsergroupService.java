package com.user;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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

  
  
  
  public Optional<UserView> updateAssociatedUserGroups(String uuid, List<String> desiredGroupIds) {
    User user = userRepository.findById(uuid)
        .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + uuid));

    // Get current group UUIDs
    Set<String> currentGroupIds = user.getUserGroups().stream()
        .map(UserGroup::getUuid)
        .collect(Collectors.toSet());

    // Separate desiredGroupIds into existing and new
    Set<String> idsToAdd = desiredGroupIds.stream()
        .filter(id -> !currentGroupIds.contains(id))
        .collect(Collectors.toSet());

    // Load new groups from DB
    List<UserGroup> groupsToAdd = idsToAdd.stream()
        .map(id -> usergroupRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("UserGroup not found: " + id)))
        .toList();

    // Remove groups not in desired list
    List<UserGroup> updatedGroups = user.getUserGroups().stream()
        .filter(group -> desiredGroupIds.contains(group.getUuid()))
        .collect(Collectors.toList());

    updatedGroups.addAll(groupsToAdd); // Safe: using modifiable list

    user.setUserGroups(updatedGroups);

    User savedUser = userRepository.save(user);

    return userMapper.toOptionalView(Optional.of(savedUser));
}


}
  
  
  

