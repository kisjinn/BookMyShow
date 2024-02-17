package bms.com.BookMyShow.repositories;

import bms.com.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
Even though we cant create object of an interface but here we will be able to create object of an interface as it is extending Jparepository
 */
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);

    //saving showSeat as blocked in DB
    //If we are creating new obj then save method act like a insert
    //If we are updating the object, then save method will just save updated object
    //Such method known as upsert method (update+insert)
    @Override
    ShowSeat save(ShowSeat showSeat);
}
