package dev.erp.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Teacher {
    // TODO: Map students and their info
    // TODO: Add course curriculum info
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String department;
    private String subject;

    @OneToOne
    @JoinColumn(name="userID")
    private User teacher;

    @OneToOne(mappedBy = "teacherSubject",cascade = CascadeType.ALL)
    private Subject subjectDetails;

    @OneToMany(mappedBy = "assignedTeacher",cascade = CascadeType.ALL)
    private List<Student> TeacherStudent = new ArrayList<>();

    public List<Student> getTeacherStudent() {
        return TeacherStudent;
    }

    public void setTeacherStudent(List<Student> teacherStudent) {
        TeacherStudent = teacherStudent;
    }

    public void setSubjectDetails(Subject subjectDetails) {
        this.subjectDetails = subjectDetails;
    }



    public int getTeacherId() {
        return teacherId;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
