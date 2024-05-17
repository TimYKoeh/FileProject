package com.user;

import java.util.List;
import com.user.model.User;

public interface FilteredUserRepository {


  public List<User> getUserList(String uuid, String name, String password);

}
