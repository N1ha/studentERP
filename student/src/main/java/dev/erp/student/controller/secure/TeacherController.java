package dev.erp.student.controller.secure;

import dev.erp.student.model.Student;
import dev.erp.student.model.Teacher;
import dev.erp.student.model.User;

import dev.erp.student.repository.TeacherRepository;
import dev.erp.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    @Autowired
    public TeacherController(TeacherRepository teacherRepository,UserRepository userRepository){
        this.teacherRepository = teacherRepository;
        this.userRepository=userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> AddTeacher(@RequestBody Teacher teacher, @RequestParam String username){
        var u=userRepository.findByUsername(username);
        u.setTeacherData(teacher);
        userRepository.save(u);
        teacher.setTeacher(u);
        return ResponseEntity.ok(teacherRepository.save(teacher));
    }

    @GetMapping("/show")
    public ResponseEntity<User> showTeacher(@RequestParam String username){

        return ResponseEntity.ok(userRepository.findByUsername(username));
    }
}
