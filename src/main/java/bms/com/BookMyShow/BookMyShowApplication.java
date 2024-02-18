package bms.com.BookMyShow;

import bms.com.BookMyShow.controllers.UserController;
import bms.com.BookMyShow.dtos.SignUpRequestDto;
import bms.com.BookMyShow.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing   //whenever any changes happen on db, listen to that event
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
     private UserController userController;
	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		signUpRequestDto.setEmail("sakshijinnewar");
		signUpRequestDto.setPassword("anc");

		SignUpResponseDto responseDto = userController.signUp(signUpRequestDto);



	}
}
