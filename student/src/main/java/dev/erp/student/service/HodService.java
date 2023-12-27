package dev.erp.student.service;

import dev.erp.student.model.Hod;
import dev.erp.student.model.User;
import dev.erp.student.repository.HodRepository;
import dev.erp.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class HodService {
    private final HodRepository hodRepository;
    private final UserRepository userRepository;
    @Autowired
    public HodService(HodRepository hodRepository,UserRepository userRepository){
        this.hodRepository = hodRepository;
        this.userRepository=userRepository;
    }


    public Hod AddHod(@RequestBody Hod hod, @RequestParam String username){
        var u=userRepository.findByUsername(username);
        u.setHodTeacher(hod);
        userRepository.save(u);
        hod.setHod(u);
        return hodRepository.save(hod);
    }


    public User showHod(@RequestParam String username){

        return userRepository.findByUsername(username);
    }
}
