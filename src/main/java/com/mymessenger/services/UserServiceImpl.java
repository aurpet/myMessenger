package com.mymessenger.services;

import com.mymessenger.dto.UserDto;
import com.mymessenger.model.User;
import com.mymessenger.repo.UserRepository;
import com.mymessenger.utils.Roles;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aurimas
 * @created 2023-04-03
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        User accountUser = new User(user.getUserName(),
                passwordEncoder.encode(user.getPassword()),
                user.getRoles());
        return userRepository.save(accountUser);
    }

    @Override
    public boolean userExist(String userName) {
        User user = userRepository.findByUserName(userName);
        return user != null;
    }

    @Override
    public String deleteUser(User user) {
        boolean isAdmin = user.getRoles().stream().anyMatch(v -> v.getRoleName().equals(Roles.ROLE_ADMIN.toString()));
        if (isAdmin){
            return "Admin account can't be deleted";
        } else {
            userRepository.delete(user);
            return "User successfully deleted";
        }
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> users = userRepository.findAll().stream()
                .map(user ->  UserDto.builder()
                        .id(user.getId())
                        .userName(user.getUserName())
                        .createdAd(user.getCreatedAt())
                        .roles(user.getRoles().stream().map(e->e.getRoleName()).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
