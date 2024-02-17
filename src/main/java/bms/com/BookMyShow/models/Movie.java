package bms.com.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity (name = "movies")
public class Movie extends Base{
    private String name;
}
