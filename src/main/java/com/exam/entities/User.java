package com.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String mobile;
    private boolean enabled=true;
    private String profilePicPath;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    public User(Long id, String username, String password, String firstName,
                String middleName, String lastName, String email,
                String mobile, boolean enabled, String profilePicPath) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.enabled = enabled;
        this.profilePicPath = profilePicPath;
    }

}
