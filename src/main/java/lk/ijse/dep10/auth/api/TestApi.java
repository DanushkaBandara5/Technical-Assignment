package lk.ijse.dep10.auth.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestApi {
    @GetMapping
    public String get(){
        return "<h1>Hello Danushka</h1>";
    }
}
