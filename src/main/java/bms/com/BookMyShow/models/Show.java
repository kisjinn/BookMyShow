package bms.com.BookMyShow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity (name = "shows")
public class Show extends Base{
    @ManyToOne
    private Movie name;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection    //as we haved list of features so collection
    private List<Feature> features;

}
/*
    1         ---->      1
  Show  ------------  Movie
    M        <------     1

        1 ---->      1
  Show ------------ Screen
    M    <------     1
 */
