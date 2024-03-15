package bms.com.BookMyShow;

import bms.com.BookMyShow.controllers.UserController;
import bms.com.BookMyShow.dtos.BookMovieRequestDto;
import bms.com.BookMyShow.dtos.BookMovieResponseDto;
import bms.com.BookMyShow.dtos.SignUpRequestDto;
import bms.com.BookMyShow.dtos.SignUpResponseDto;
import bms.com.BookMyShow.models.ShowSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing   //whenever any changes happen on db, listen to that event
//commnadlinerunner used to implemnet dummy testing
//run method of commnnadlineRunner will get executed when we launch the application
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;
	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		signUpRequestDto.setEmail("snehaljinnewar@gmail.com");
		signUpRequestDto.setPassword("abc");
		SignUpResponseDto responseDto = userController.signUp(signUpRequestDto);

		/*Incomplete Booking Service
		BookMovieRequestDto bookMovieRequestDto= new BookMovieRequestDto();
		bookMovieRequestDto.setUserId(123L);
		bookMovieRequestDto.setShowId(3L);
		List<ShowSeat> seats = new ArrayList<>();
		*/


	}
}
