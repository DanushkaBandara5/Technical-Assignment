package lk.ijse.dep10.auth.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 2000)
    @NotNull @Length(min = 5,max = 200)
    private String userName;
    @Column(nullable = false,length = 200)
    @NotNull @Length(min=5,max = 200)
    private String password;
    public User(String userName,String password){
        this.userName=userName;
        this.password=getPassword();
    }
}
