package dev.erp.student.controller.insecure;

import dev.erp.student.dto.request.UserLogin;
import dev.erp.student.dto.request.UserRegister;
import dev.erp.student.dto.response.Message;
import dev.erp.student.model.User;
import dev.erp.student.service.RegisterService;
import dev.erp.student.utils.GetUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/")
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping("signup")
    public ResponseEntity<User> signup(@RequestBody UserRegister user){
        User u = registerService.signup(user, user.getRole());
        if(u != null){
            return ResponseEntity.ok(u);
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
    }

    @PostMapping("login")
    public ResponseEntity<Message> login(@RequestBody UserLogin user){
        boolean isLogin = registerService.login(user);
        return isLogin ?
                ResponseEntity.ok(
                        Message.builder().status(1).message("user successfully logged in")
                                .timestamp(GetUtils.TIMESTAMP)
                                .build()
                ) :
                ResponseEntity.status(401).build();
    }
}
