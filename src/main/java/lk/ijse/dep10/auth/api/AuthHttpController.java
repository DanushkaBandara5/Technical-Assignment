package lk.ijse.dep10.auth.api;

import lk.ijse.dep10.auth.auth.AuthRequest;
import lk.ijse.dep10.auth.auth.AuthResponse;
import lk.ijse.dep10.auth.entity.User;
import lk.ijse.dep10.auth.entity.UserLoginDetails;
import lk.ijse.dep10.auth.jwt.JwtTokenUtility;
import lk.ijse.dep10.auth.repository.UserLoginDetailsRepository;
import lk.ijse.dep10.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class AuthHttpController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtTokenUtility jwtTokenUtility;
    @Autowired
    private UserLoginDetailsRepository userLoginDetails;
    @Autowired
    private UserRepository userRepository;
@ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/v1/auth/login")
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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/api/v1/auth/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signup(@RequestBody @Valid AuthRequest request){
        String password = passwordEncoder.encode(request.getPassword());

        User user = new User(request.getUserName(), password);
        if(userRepository.findByUserName(request.getUserName()).isPresent()){

           return new ResponseEntity<>("Username Already Exist",HttpStatus.CONFLICT);
        }
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
