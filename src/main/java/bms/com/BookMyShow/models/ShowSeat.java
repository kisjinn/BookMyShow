package bms.com.BookMyShow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "show_seat")
public class ShowSeat extends Base{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStaus;
}
/*
    1         ---->      1
  ShowSeat ------------ Show
    M        <------     1

    1         ---->      1
  ShowSeat ------------ Seat
    M        <------     1
 */
