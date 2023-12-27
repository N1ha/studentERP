package dev.erp.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    // TODO: Add attendance property
    // TODO: Add scores property
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private long  rollno;
    private String course;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Subject>sub = new ArrayList<>();
    @OneToOne
    @JoinColumn(name="userID")
    private User student;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher assignedTeacher;

    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }

    public List<Subject> getSub() {
        return sub;
    }

    public void setSub(List<Subject> sub) {
        this.sub = sub;
    }

    public int getStudentId() {
        return studentId;
    }
    public long getRollno() {
        return rollno;
    }
    public void setRollno(long rollno) {
        this.rollno = rollno;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setStudent(User student) {
        this.student = student;
    }

    
}
