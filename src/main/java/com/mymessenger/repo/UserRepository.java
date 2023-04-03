package com.mymessenger.repo;

import com.mymessenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aurimas
 * @created 2023-04-03
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
