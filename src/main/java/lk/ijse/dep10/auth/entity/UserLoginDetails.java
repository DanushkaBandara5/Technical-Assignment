package lk.ijse.dep10.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class UserLoginDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length =200)
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false,referencedColumnName = "id")
    private User user;
    public UserLoginDetails(LocalDateTime dateTime,User user){
        this.user=user;
        this.dateTime=dateTime;
    }
}
