package bms.com.BookMyShow.models;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "theatres")
public class Theatre extends  Base{
    private  String name;
    @ManyToOne
    private Region region;
    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;


}
/*
    1         ---->      1
  Theatre ------------Region
    M        <------     1

     1       ---->      M
  Theatre ------------Screen
     1      <------     1
*/
