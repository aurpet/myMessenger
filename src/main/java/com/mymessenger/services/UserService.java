package com.mymessenger.services;

import com.mymessenger.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Aurimas
 * @created 2023-04-03
 */

public interface UserService extends UserDetailsService {
    User save(User registrationDto);
    boolean userExist(String nickName);
}
