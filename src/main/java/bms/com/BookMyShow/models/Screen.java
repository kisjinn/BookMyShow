package bms.com.BookMyShow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "screens")
public class Screen extends Base{
  private Screen name;
  @OneToMany (mappedBy = "screen")
  private List<Seat> seats;
  @Enumerated(EnumType.ORDINAL)
  @ElementCollection    //as we haved list of features so collection
  private List<Feature> features;
  @ManyToOne
  private Theatre theatre;
}
