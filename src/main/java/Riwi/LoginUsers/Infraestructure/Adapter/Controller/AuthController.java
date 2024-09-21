package Riwi.LoginUsers.Infraestructure.Adapter.Controller;


import Riwi.LoginUsers.Application.LoginService;
import Riwi.LoginUsers.Application.UserService;
import Riwi.LoginUsers.Infraestructure.Adapter.Request.LoginRequest;
import Riwi.LoginUsers.Infraestructure.Adapter.Request.SignupRequest;
import Riwi.LoginUsers.Infraestructure.Adapter.Response.LoginResponse;
import Riwi.LoginUsers.Infraestructure.Adapter.Response.SignupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        SignupResponse response = userService.registerUser(signupRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = loginService.authenticate(loginRequest);
        if (response.getMessage().startsWith("Error")) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }


}

