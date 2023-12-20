package dev.erp.student.service;

import dev.erp.student.dto.request.UserLogin;
import dev.erp.student.dto.request.UserRegister;
import dev.erp.student.model.User;
import dev.erp.student.repository.UserRepository;
import dev.erp.student.utils.EntityRole;
import dev.erp.student.utils.GetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public RegisterService(UserRepository userRepository,
                              PasswordEncoder passwordEncoder,
                              AuthenticationManager authenticationManager
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(UserRegister user, String Role) {
        if(userRepository.findByUsername(user.getUsername()) == null){
            Role = Role.trim().toUpperCase();
            User u = User.builder()
                    .username(user.getUsername()).email(user.getEmail())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .firstName(user.getFirstName()).lastName(user.getLastName())
                    .role(EntityRole.valueOf(GetUtils.ROLE_ + Role))
                    .build();
            return userRepository.save(u);
        }
        return null;
    }

    public boolean login(@RequestBody UserLogin user){
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        ).isAuthenticated();
    }
}
