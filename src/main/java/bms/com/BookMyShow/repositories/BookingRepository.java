package bms.com.BookMyShow.repositories;

import bms.com.BookMyShow.models.Booking;
import bms.com.BookMyShow.services.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);
}
