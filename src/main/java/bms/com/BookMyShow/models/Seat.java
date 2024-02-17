package bms.com.BookMyShow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "seats")
public class Seat extends Base{
    private String NUmber;
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int columnVal;
    @ManyToOne
    private Screen screen;
}
