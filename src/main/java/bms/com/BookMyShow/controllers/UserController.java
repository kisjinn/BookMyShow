package bms.com.BookMyShow.controllers;

import bms.com.BookMyShow.dtos.SignUpRequestDto;
import bms.com.BookMyShow.dtos.SignUpResponseDto;
import bms.com.BookMyShow.models.User;
import bms.com.BookMyShow.services.UserServices;

public class UserController {
    private UserServices userServices;
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
          try{
              User user = userServices.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
          }
          catch (Exception e){

          }
          return null;
    }

}
