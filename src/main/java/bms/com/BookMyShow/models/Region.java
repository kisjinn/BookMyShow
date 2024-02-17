package bms.com.BookMyShow.models;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity (name = "regions")
public class Region extends Base{
    private String name;
    //private List<Theatre> theatres;
}
