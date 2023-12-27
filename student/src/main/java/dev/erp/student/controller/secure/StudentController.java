package dev.erp.student.controller.secure;

import dev.erp.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.erp.student.model.Student;
import dev.erp.student.model.User;



@RestController
@RequestMapping("/api/student")

public class StudentController {
    // TODO: separate the service layer
    // TODO: use DTO to get only the required Information


    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
  
    @PostMapping("/add")
    public ResponseEntity<Student> AddStudent(@RequestBody Student student,@RequestParam String username){
        return ResponseEntity.ok(studentService.AddStudent(student,username));
    }

    @GetMapping("/show")
    public ResponseEntity<User> showstudent(@RequestParam String username){
        return ResponseEntity.ok(studentService.showstudent(username));
    }
    


}
