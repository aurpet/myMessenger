package com.mymessenger.services;

import com.mymessenger.dto.UserDto;
import com.mymessenger.model.User;

import java.util.List;

/**
 * @author Aurimas
 * @created 2023-04-03
 */

public interface UserService {
    User save(User user);
    boolean userExist(String userName);
    String deleteUser(User user);
    List<UserDto>findAllUsers();
    User findUserByName(String userName);
}
