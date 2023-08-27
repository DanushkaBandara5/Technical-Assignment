package lk.ijse.dep10.auth.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.objenesis.instantiator.sun.MagicInstantiator;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotNull(message = "UserName cannot be empty") @Length(min = 3,message = "UserName length must be greater than 3" )
    private String userName;
    @NotNull(message = "password cannot be empty")
     @Length(min = 5,message = "password length must be greater than 5")
    private String password;

}
