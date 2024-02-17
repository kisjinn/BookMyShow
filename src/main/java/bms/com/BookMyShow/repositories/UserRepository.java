package bms.com.BookMyShow.repositories;

import bms.com.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userId); //select * from user where userId= userId

    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}
