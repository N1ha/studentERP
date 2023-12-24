package dev.erp.student.controller.secure;

import dev.erp.student.model.Hod;
import dev.erp.student.model.Teacher;
import dev.erp.student.model.User;
import dev.erp.student.repository.HodRepository;
import dev.erp.student.repository.TeacherRepository;
import dev.erp.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hod")
public class HodController {
    private final HodRepository hodRepository;
    private final UserRepository userRepository;
    @Autowired
    public HodController(HodRepository hodRepository,UserRepository userRepository){
        this.hodRepository = hodRepository;
        this.userRepository=userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Hod> AddTeacher(@RequestBody Hod hod, @RequestParam String username){
        var u=userRepository.findByUsername(username);
        u.setHodTeacher(hod);
        userRepository.save(u);
        hod.setHod(u);
        return ResponseEntity.ok(hodRepository.save(hod));
    }

    @GetMapping("/show")
    public ResponseEntity<User> showTeacher(@RequestParam String username){

        return ResponseEntity.ok(userRepository.findByUsername(username));
    }
}
