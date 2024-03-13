package bms.com.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "bookings")
//Ticket class
public class Booking extends Base{
    //Ticket
    private BookingStatus bookingStatus;
    @OneToMany
    private List<ShowSeat> showSeat;
    private int amount;
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
    @ManyToOne
    private User user;
}

/*
    1         ---->      M
  Booking ------------ ShowSeat
    1        <------     1


        1    ---->      1
  Booking ------------User
         M <------     1
 */
