package lk.ijse.dep10.auth.repository;

import lk.ijse.dep10.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUserName(String userName);
}
