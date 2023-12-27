package dev.erp.student.controller.secure;

import dev.erp.student.model.Student;
import dev.erp.student.model.Subject;
import dev.erp.student.model.Teacher;
import dev.erp.student.model.User;

import dev.erp.student.repository.TeacherRepository;
import dev.erp.student.repository.UserRepository;
import dev.erp.student.service.TeacherSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")

public class TeacherController {
    // TODO: separate the service layer
    // TODO: use DTO to get only the required Information

    private final TeacherSerivce teacherSerivce;
    @Autowired
    public TeacherController(TeacherSerivce teacherSerivce){
        this.teacherSerivce=teacherSerivce;
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> AddTeacher(@RequestBody Teacher teacher, @RequestParam String username){

        return ResponseEntity.ok(teacherSerivce.AddTeacher(teacher,username));
    }

    @GetMapping("/show")
    public ResponseEntity<User> showTeacher(@RequestParam String username){

        return ResponseEntity.ok(teacherSerivce.showTeacher(username));
    }

    @PostMapping("/subject/add")
    public ResponseEntity<Subject> addsubject(@RequestParam String teachername
            ,@RequestParam String studentname
            ,@RequestBody Subject subject )
    {

    }
}
