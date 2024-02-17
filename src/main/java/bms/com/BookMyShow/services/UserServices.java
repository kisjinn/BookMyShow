package bms.com.BookMyShow.services;

import bms.com.BookMyShow.models.User;
import bms.com.BookMyShow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    UserRepository userRepository;
    UserServices(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public User signUp(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);;
        if(optionalUser.isPresent()){
            //Call the login method
            //throw new UnsupportedOperationException("User is not registered");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassWord(password);

        //save the data
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User SignIn(String email, String password){
        return null;
    }


}
