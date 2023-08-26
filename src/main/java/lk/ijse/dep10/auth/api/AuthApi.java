package lk.ijse.dep10.auth.api;

import lk.ijse.dep10.auth.auth.AuthRequest;
import lk.ijse.dep10.auth.auth.AuthResponse;
import lk.ijse.dep10.auth.entity.User;
import lk.ijse.dep10.auth.entity.UserLoginDetails;
import lk.ijse.dep10.auth.jwt.JwtTokenUtility;
import lk.ijse.dep10.auth.repository.UserLoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class AuthApi {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtTokenUtility jwtTokenUtility;
    @Autowired
    private UserLoginDetailsRepository userLoginDetails;

    @PostMapping("/auth/log")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        System.out.println("hello");
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUserName(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtTokenUtility.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);


            LocalDateTime dateTime = LocalDateTime.now();
            UserLoginDetails userLogDetails = new UserLoginDetails(user, dateTime);
            userLoginDetails.save(userLogDetails);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
