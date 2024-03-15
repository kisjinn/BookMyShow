package bms.com.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity (name = "seat_types")
public class SeatType extends Base {
    private String name;

}
