package bms.com.BookMyShow.services;

import bms.com.BookMyShow.exceptions.ShowSeatNotAvailableException;
import bms.com.BookMyShow.models.*;
import bms.com.BookMyShow.repositories.BookingRepository;
import bms.com.BookMyShow.repositories.ShowRepository;
import bms.com.BookMyShow.repositories.ShowSeatRepository;
import bms.com.BookMyShow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Setter
@Getter
@Service
//service/component annotation to tell SB to create object of curr class automatically at compile time which help us in resolving dependency
//Component and service both annotations used for the same purpose
public class BookingService {

    //All Repositories are interfaces and we can't create object of an interface But here all interfaces extended JpaRepository
    //which enable us to make object of this repositories interfaces as well
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private  PriceCalculatorService priceCalculatorService;
    private BookingRepository bookingRepository;
    BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService, BookingRepository bookingRepository){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository=bookingRepository;
    }
    //putting lock on complete method
    @Transactional       //(isolation=Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userID, Long showId, List<Long> showSeatId) throws ShowSeatNotAvailableException {
        /*
------DISCLAIMER: as having lock in between in SB is a advance Concept so for BMS design purpose, we will take a lock on complete method => Transactional annotation-----------------------------------
             ------------Take a LOCK-------------------
        1. Get the user with given userId
        2. Get show with given shwoId
        3. Get list of showSeats with the given showSeatId
        4. Check if all showseats are available or not
        5. If not available then throw an exception
        *****************If available then Take a LOCK***************************
        Check status of the showSeats again => Double-Checking
        6. If available, then block the seats
        7. Save the status in DB
        *****************Release a LOCK***********************
        8. Create the booking object
        9. Booking service will return booking object (Payment thing we will do in project module)
                           ----------RELEASE a LOCK-------------------
        */
        //Getting all values from DB using repository interfaces of respective models
        Optional<User> optionalUser = userRepository.findById(userID);
        if(optionalUser.isEmpty()){
            //throw an exception
            throw new UnsupportedOperationException("User is not registered");
        }
        User user= optionalUser.get();


        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            //throw an exception
            throw new UnsupportedOperationException("Show not found");
        }
        Show show= optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatId);

        //4. Check if all showseats are available or not
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStaus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Seats are not available for show");
            }
        }

        //6. If available, then block the seats
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStaus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking= new Booking();
        booking.setUser(user);
        booking.setShowSeat(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING); //this will send to payment gateway, payment will done and then this bookingstatus will change to Confirmed
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show));
        Booking savedBooking = bookingRepository.save(booking);


        return savedBooking;
    }

}
