package lk.ijse.dep10.auth.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestApi {
    @GetMapping("/auth")
    public String get(){
        return "<h1>Hello girls</h1>";
    }
}
