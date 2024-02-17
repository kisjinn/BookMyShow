package bms.com.BookMyShow.models;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "users")
public class User extends Base{
    private String name;
    private String email;
    private String passWord;
    @OneToMany(mappedBy = "user")
    private List<Booking> booking;
}

/*
1 user can have many bookings
1 booking can belong to 1 user only
So User -----1 to many relation-------- Booking

*/
