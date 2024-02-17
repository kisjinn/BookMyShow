package bms.com.BookMyShow.models;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "show_seat_type")
public class ShowSeatType extends Base{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}
