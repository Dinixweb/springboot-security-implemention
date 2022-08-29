package io.dinixweb.Springboot.Security;

import io.dinixweb.Springboot.Security.model.Students;
import io.dinixweb.Springboot.Security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringbootSecurityApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityApplication.class, args);
	}

	BCryptPasswordEncoder encode   = new BCryptPasswordEncoder();

	public void run(String... args)throws Exception{
		Students students = new Students();
		students.setFirstName("Dennis");
		students.setLastName("Shaba");
		students.setGrade("Grade 12");
		students.setEmail("denis@gmail.com");
		students.setUsername("Dinix");
		students.setPassword(encode.encode("Nigeria"));

		students.setFirstName("Mike");
		students.setLastName("Hillary");
		students.setGrade("Grade 11");
		students.setEmail("hillary_mike@gmail.com");
		students.setUsername("hillary");
		students.setPassword(encode.encode("Nigeria"));

		studentRepository.save(students);
	}


}
