package com.exam.services;

import com.exam.entities.User;
import com.exam.entities.UserRole;

import java.util.Set;

/**
 * A User Service
 */
public interface UserService {

    /**
     * Create a user
     *
     * @param user
     * @param userRoles
     * @return
     */
    User createUser(User user, Set<UserRole> userRoles) throws Exception;
}