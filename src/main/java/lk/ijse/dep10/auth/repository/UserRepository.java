package lk.ijse.dep10.auth.repository;

import lk.ijse.dep10.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
