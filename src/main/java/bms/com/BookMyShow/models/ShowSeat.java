package bms.com.BookMyShow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "show_seats")
public class ShowSeat extends Base{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL) //enum values will be mapped with integres and that integer will use as a foreign key in this table
    private ShowSeatStatus showSeatStaus;
    @ManyToOne
    private Booking booking;
}
/*
    1         ---->      1
  ShowSeat ------------ Show
    M        <------     1

    1         ---->      1
  ShowSeat ------------ Seat
    M        <------     1
 */
