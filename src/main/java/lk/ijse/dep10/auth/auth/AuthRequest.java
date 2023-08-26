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
    @NotNull @Length(min = 3 )
    private String userName;
    @NotNull
     @Length(min = 3,max = 15)
    private String password;

}
