package com.exam.controllers;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {

        Role role = new Role();
        role.setId(2L);
        role.setRoleName("REGULAR");

        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoles.add(userRole);

        return new ResponseEntity<>(this.userService.createUser(user,userRoles),
                HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> GetUserByUsername(@PathVariable("username") String username){
        return new ResponseEntity<>(this.userService.browseUserByUsername(username),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        this.userService.deleteUserById(id);
        return new ResponseEntity<>("Resource Deletion Success",HttpStatus.OK);
    }

    //TODO: Update Mapping
}
