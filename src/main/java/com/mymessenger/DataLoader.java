package com.mymessenger;

import com.mymessenger.model.Role;
import com.mymessenger.model.User;
import com.mymessenger.services.UserService;
import com.mymessenger.utils.Roles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Aurimas
 * @created 2023-04-03
 */
@Component
public class DataLoader implements ApplicationRunner {
    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createUser();
    }

    private void createUser(){
        User adminUser = new User("admin", "adminas", Arrays.asList(new Role(Roles.ROLE_ADMIN)));
        User  baseUser = new User("Aurimas", "aurimas", Arrays.asList(new Role(Roles.ROLE_USER),
                new Role(Roles.ROLE_GUEST)));

        userService.save(adminUser);
        userService.save(baseUser);
    }
}
