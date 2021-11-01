package com.maxxi.maxxi;

import java.util.HashSet;
import java.util.Set;

import com.maxxi.maxxi.models.ERole;
import com.maxxi.maxxi.models.Role;
import com.maxxi.maxxi.models.User;
import com.maxxi.maxxi.repository.RoleRepository;
import com.maxxi.maxxi.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class MaxxiApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(MaxxiApplication.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Value("${admin.username}")
	private String username;

	@Value("${admin.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(MaxxiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findByUsername(username)==null){
			Set<Role> roles= new HashSet<>();
			Set<Role> roleUser1 = new HashSet<>();
        	roleUser1.add(new Role(ERole.ROLE_ADMIN));
			Set<Role> roleUser2 = new HashSet<>();
			roleUser2.add(new Role(ERole.ROLE_PETANI));
			
			
			Role userrole= new Role();
			userrole.setName(ERole.ROLE_ADMIN);
			Role adminrole= new Role();
			adminrole.setName(ERole.ROLE_PETANI);
			roleRepository.save(userrole);
			roleRepository.save(adminrole);
			roles.add(userrole);
			roles.add(adminrole);

			if(userRepository.count() == 0){
				User user1 = new User();
				user1.setUsername("Fif");
				user1.setEmail("afiflampard32@gmail.com");
				user1.setPassword(bcryptEncoder.encode("1234"));
				user1.setNama("Afif Musyayyidin");
				user1.setAlamat("Babatan");
				user1.setNo_ktp("15050412980001");
				user1.setNo_telp("09876664499");
				
				user1.setRoles(roleUser1);
				userRepository.save(user1);
				Long idUser1 = user1.getId();
				user1.setCode("TPA - 00"+idUser1);
				userRepository.save(user1);
	
				User user2 = new User();
				user2.setUsername("fifa");
				user2.setEmail("fifa32@gmail.com");
				user2.setPassword(bcryptEncoder.encode("1234"));
				user2.setNama("Afif Musyayyidin");
				user2.setAlamat("Babatan");
				user2.setNo_ktp("155050412980001");
				user2.setNo_telp("081615962254");
				user2.setRoles(roleUser2);
				userRepository.save(user2);
				Long idUser2 = user2.getId();
				user2.setCode("TPA - 00"+idUser2);
				userRepository.save(user2);

			// User user = new User();
			// user.setUsername(username);
			// user.setPassword(bcryptEncoder.encode(password));
			// user.setEmail("afiflampard32@gmail.com");
			// user.setRoles(roles);
			// userRepository.save(user);
			logger.info(username +" user is added. " + username + " has Admin Role.");
		} else {
			logger.info(username + " user already exists. "+username + " has Admin Role.");
		}
	}
		
	
	}	

}
