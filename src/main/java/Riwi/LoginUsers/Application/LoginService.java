package Riwi.LoginUsers.Application;

import Riwi.LoginUsers.Domain.Model.User;
import Riwi.LoginUsers.Infraestructure.Adapter.Request.LoginRequest;
import Riwi.LoginUsers.Infraestructure.Adapter.Response.LoginResponse;
import Riwi.LoginUsers.Infraestructure.Persistence.Helpers.JwtUtil;
import Riwi.LoginUsers.Infraestructure.Persistence.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElse(null);

        if (user == null) {
            return new LoginResponse("Error: User not found", null);
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new LoginResponse("Error: Invalid password", null);
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse("Login successful", token);
    }
}
