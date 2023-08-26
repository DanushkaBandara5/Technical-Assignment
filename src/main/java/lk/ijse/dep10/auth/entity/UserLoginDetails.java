package lk.ijse.dep10.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false,referencedColumnName = "id")
    private User user;
    public UserLoginDetails(User user,LocalDateTime dateTime){
        this.user=user;
        this.dateTime=dateTime;
    }
}
