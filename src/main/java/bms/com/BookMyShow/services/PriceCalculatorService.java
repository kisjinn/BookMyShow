package bms.com.BookMyShow.services;

import bms.com.BookMyShow.models.Show;
import bms.com.BookMyShow.models.ShowSeat;
import bms.com.BookMyShow.models.ShowSeatType;
import bms.com.BookMyShow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeREpository){
        this.showSeatTypeRepository= showSeatTypeREpository;
    }
    public  int calculatePrice(List<ShowSeat> showSeats, Show show){
      List<ShowSeatType> showSeatsType= showSeatTypeRepository.findAllByShow(show);
      int amount=0;
      for(ShowSeat showSeat: showSeats){
          for(ShowSeatType showSeatType: showSeatsType){
              if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                  amount += showSeatType.getPrice();
                  break;
              }
          }
      }
      return amount;
    }
}
