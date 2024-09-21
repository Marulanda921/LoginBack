package Riwi.LoginUsers.Application;

import Riwi.LoginUsers.Domain.Model.Role;
import Riwi.LoginUsers.Domain.Model.User;
import Riwi.LoginUsers.Infraestructure.Adapter.Request.SignupRequest;
import Riwi.LoginUsers.Infraestructure.Adapter.Response.SignupResponse;
import Riwi.LoginUsers.Infraestructure.Persistence.Repository.RoleRepository;
import Riwi.LoginUsers.Infraestructure.Persistence.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponse registerUser(SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()) != null) {
            return new SignupResponse("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return new SignupResponse("Error: Email is already in use!");
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

        roleRepository.findByName("USER").ifPresent(roles::add);

        if (signupRequest.getRoles() != null && signupRequest.getRoles().contains("ADMIN")) {
            roleRepository.findByName("ADMIN").ifPresent(roles::add);
        }

        user.setRoles(roles);
        userRepository.save(user);

        return new SignupResponse("User registered successfully!");
    }
}
