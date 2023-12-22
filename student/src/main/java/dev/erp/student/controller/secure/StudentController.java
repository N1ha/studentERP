package dev.erp.student.controller.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.erp.student.model.Student;
import dev.erp.student.model.User;
import dev.erp.student.repository.StudentRepository;
import dev.erp.student.repository.UserRepository;
import lombok.var;

@RestController
@RequestMapping("/api/student")

public class StudentController {
    
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository,UserRepository userRepository){
        this.studentRepository = studentRepository;
        this.userRepository=userRepository;
    }
  
    @PostMapping("/add")
    public ResponseEntity<Student> AddStudent(@RequestBody Student student,@RequestParam String username){
       var u=userRepository.findByUsername(username);
       u.setStudentData(student);
       userRepository.save(u);
        student.setStudent(u);
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/show")
    public ResponseEntity<User> showstudent(@RequestParam String username){
    
        return ResponseEntity.ok(userRepository.findByUsername(username));
    }
    


}
