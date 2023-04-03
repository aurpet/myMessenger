package com.mymessenger.services;

import com.mymessenger.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

/**
 * @author Aurimas
 * @created 2023-04-03
 */

public interface UserService extends UserDetailsService {
    User save(User user);
    boolean userExist(String userName);
    Map<Long, String> getAllUsers();
}
