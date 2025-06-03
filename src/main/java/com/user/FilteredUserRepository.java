package com.user;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.user.model.User;
import com.user.view.UserDetailView;

public interface FilteredUserRepository {


  public List<User> getUserList(String uuid, String name, String password);
  //public UserDetailView getUserDetail(String uuid);
}
