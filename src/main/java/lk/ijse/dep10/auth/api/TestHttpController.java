package lk.ijse.dep10.auth.api;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHttpController {
    //This api layer was designed to testing
    @GetMapping("/api/v1/auth")
    @ApiImplicitParam(name = "Authorization", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer jwt-token")
    public String get(){
        return "<h1>This is working</h1>";
    }
}
