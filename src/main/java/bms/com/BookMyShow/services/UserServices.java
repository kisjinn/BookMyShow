package bms.com.BookMyShow.services;

import bms.com.BookMyShow.models.User;
import bms.com.BookMyShow.repositories.UserRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Optional;

@Service
public class UserServices {
    UserRepository userRepository;
    UserServices(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public User signUp(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User savedUser = null;
        if(optionalUser.isPresent()){
            //Call the login method
            //throw new UnsupportedOperationException("User is not registered");
            savedUser = SignIn(email, password);
        }
        //create new user
        else {
            User user = new User();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setEmail(email);
            user.setPassWord(bCryptPasswordEncoder.encode(password));
            //save the data
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }

    public User SignIn(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        User user= optionalUser.get();
        if(bCryptPasswordEncoder.matches(password, user.getPassWord())){
            System.out.println("Sign In Successfull");
        }
        else{
            System.out.println("Wrong password");
        }
        return null;
    }


}
