package dev.erp.student.controller.secure;

import dev.erp.student.model.Hod;
import dev.erp.student.model.Teacher;
import dev.erp.student.model.User;
import dev.erp.student.repository.HodRepository;
import dev.erp.student.repository.TeacherRepository;
import dev.erp.student.repository.UserRepository;
import dev.erp.student.service.HodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hod")
public class HodController {
    // TODO: separate the service layer
    // TODO: use DTO to get only the required Information
    private final HodService hodService;
    @Autowired
    public HodController(HodService hodService){
        this.hodService=hodService;
    }

    @PostMapping("/add")
    public ResponseEntity<Hod> AddHod(@RequestBody Hod hod, @RequestParam String username){

        return ResponseEntity.ok(hodService.AddHod(hod,username));
    }

    @GetMapping("/show")
    public ResponseEntity<User> showHod(@RequestParam String username){

        return ResponseEntity.ok(hodService.showHod(username));
    }
}
