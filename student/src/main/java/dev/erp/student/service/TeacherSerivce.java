package dev.erp.student.service;

import dev.erp.student.model.Student;
import dev.erp.student.model.Subject;
import dev.erp.student.model.Teacher;
import dev.erp.student.model.User;
import dev.erp.student.repository.TeacherRepository;
import dev.erp.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class TeacherSerivce {
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    @Autowired
    public TeacherSerivce(TeacherRepository teacherRepository, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }


    public Teacher AddTeacher(Teacher teacher, String username) {
        var u = userRepository.findByUsername(username);
        u.setTeacherData(teacher);
        userRepository.save(u);
        teacher.setTeacher(u);
        return teacherRepository.save(teacher);
    }


    public User showTeacher(String username) {

        return userRepository.findByUsername(username);
    }

    public Subject addsubject(String teachername, String studentname, Subject subject)
    {
//        find student,find teacher assign suject,save;
        Student stud = userRepository.findByUsername(studentname).getStudentData();
        Teacher teach = userRepository.findByUsername(teachername).getTeacherData();
        stud.getSub().add(subject);
        teach.getTeacherStudent().add(stud);


    }

}
