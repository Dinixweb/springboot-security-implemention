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

//		Students students = new Students();
//		students.setFirstName("James");
//		students.setLastName("Gate");
//		students.setGrade("Grade 12");
//		students.setEmail("james@gmail.com");
//		students.setUsername("james");
//		students.setPassword(encode.encode("Nigeria"));
//		students.setAccountNonLocked(false);
//		studentRepository.save(students);
	}


}
