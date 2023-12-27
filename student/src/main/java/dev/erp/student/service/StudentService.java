package dev.erp.student.service;

import dev.erp.student.model.Student;
import dev.erp.student.model.User;
import dev.erp.student.repository.StudentRepository;
import dev.erp.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository,UserRepository userRepository){
        this.studentRepository = studentRepository;
        this.userRepository=userRepository;
    }


    public Student AddStudent(@RequestBody Student student, @RequestParam String username){
        var u=userRepository.findByUsername(username);
        u.setStudentData(student);
        userRepository.save(u);
        student.setStudent(u);
        return studentRepository.save(student);
    }

    public User showstudent(@RequestParam String username){

        return userRepository.findByUsername(username);
    }


}
