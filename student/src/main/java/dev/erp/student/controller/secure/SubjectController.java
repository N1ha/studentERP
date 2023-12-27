package dev.erp.student.controller.secure;

import dev.erp.student.model.Student;
import dev.erp.student.model.Subject;
import dev.erp.student.model.User;
import dev.erp.student.repository.StudentRepository;
import dev.erp.student.repository.SubjectRepository;
import dev.erp.student.repository.UserRepository;
import dev.erp.student.utils.EntityRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/subject")
public class SubjectController {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    @Autowired
    public SubjectController(SubjectRepository subjectRepository,UserRepository userRepository,StudentRepository studentRepository)
    {
        this.subjectRepository=subjectRepository;
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
    }

    @PostMapping("/add")

    public ResponseEntity<Subject>addSubject(@RequestBody Subject subject, @RequestParam String username)
    {
        User u = userRepository.findByUsername(username);
        if(u.getRole() == EntityRole.ROLE_STUDENT)
        {
            Student st=u.getStudentData();
            st.getSub().add(subject);
            studentRepository.save(st);
            return ResponseEntity.ok( subjectRepository.save(subject));

        }
        return ResponseEntity.status(404).build();

    }


}
