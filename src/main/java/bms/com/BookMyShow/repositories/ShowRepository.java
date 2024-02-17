package bms.com.BookMyShow.repositories;

import bms.com.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository  extends JpaRepository<Show,Long> {
    @Override
    Optional<Show> findById(Long aLong);
}
