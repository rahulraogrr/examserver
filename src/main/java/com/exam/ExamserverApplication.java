package com.exam;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inserting Into Tables");

		User user = new User();
		user.setFirstName("Yadagiri");
		user.setLastName("Gonda");
		user.setMiddleName("Rao");
		user.setEmail("gyr7899@yahoo.co.in");
		user.setUsername("gyr7899");
		user.setPassword("7899");
		user.setProfilePicPath("aws:\\exam\\images\\gyr");

		Role role = new Role();
		role.setId(1L);
		role.setRoleName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		User user1 = this.userService.createUser(user,userRoles);
		System.out.println("User : "+user1.getUsername() +" created successfully");
	}
}