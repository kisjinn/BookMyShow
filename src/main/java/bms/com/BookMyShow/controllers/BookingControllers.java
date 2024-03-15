package bms.com.BookMyShow.controllers;

import bms.com.BookMyShow.dtos.BookMovieRequestDto;
import bms.com.BookMyShow.dtos.BookMovieResponseDto;
import bms.com.BookMyShow.dtos.ResponseStatus;
import bms.com.BookMyShow.exceptions.ShowSeatNotAvailableException;
import bms.com.BookMyShow.models.Booking;
import bms.com.BookMyShow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingControllers {
    private BookingService bookingService;
    BookingControllers(BookingService bookingService){
        this.bookingService= bookingService;
    }

    public BookMovieResponseDto bookTicket(BookMovieRequestDto requestDTO ) throws ShowSeatNotAvailableException {
        BookMovieResponseDto bookMovieResponseDto= new BookMovieResponseDto();
        try{
             Booking booking = bookingService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatIds());
             bookMovieResponseDto.setBookingID(booking.getId());
             bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
         }
         catch (Exception e){
             bookMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
         }
         return bookMovieResponseDto;
    }

}
 