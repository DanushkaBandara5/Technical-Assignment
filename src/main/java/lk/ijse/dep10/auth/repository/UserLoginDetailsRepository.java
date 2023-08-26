package lk.ijse.dep10.auth.repository;

import lk.ijse.dep10.auth.entity.UserLoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails,String> {
}
