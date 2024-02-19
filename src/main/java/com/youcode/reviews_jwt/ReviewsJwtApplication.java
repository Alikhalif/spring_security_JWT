package com.youcode.reviews_jwt;

import com.youcode.reviews_jwt.entity.OurUsers;
import com.youcode.reviews_jwt.enums.Role;
import com.youcode.reviews_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootApplication
public class ReviewsJwtApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReviewsJwtApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Optional<OurUsers> adminAccount = userRepository.findByRole(Role.ADMIN);
		if (adminAccount.isEmpty()){
			System.out.println(adminAccount);
			//Set<Role> roles = new HashSet<Role>();
			//roles.add(Role.BASE_USER);
			OurUsers user = new OurUsers();

			user.setFirstname("ali");
			user.setLastname("khalif");
			user.setUsername("parker");
			//Set<Role> userRoles = Collections.singleton(Role.ADMIN);
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("password"));
			userRepository.save(user);
		}
	}
}
