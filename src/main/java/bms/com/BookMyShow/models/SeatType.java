package bms.com.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity (name = "seat_type")
public class SeatType extends Base {
    private String name;

}
