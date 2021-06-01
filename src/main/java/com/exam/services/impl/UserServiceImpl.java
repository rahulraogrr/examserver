package com.exam.services.impl;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.repositories.RoleRepository;
import com.exam.repositories.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * User Service Implementation
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Create a user
     *
     * @param user
     * @param userRoles
     * @return
     */
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User userFound = this.userRepository.findByUsername(user.getUsername());

        if (null!=userFound){
            System.out.println("User Already Exists!!!");
            throw new Exception("User Already Exists!!!");
        } else {
            for (UserRole userRole:userRoles){
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            userFound = this.userRepository.save(user);
        }

        return userFound;
    }

    /**
     * Browse User By His Username
     *
     * @param username
     * @return
     */
    @Override
    public User browseUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    /**
     * Delete A User
     *
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }
}