package dev.erp.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private long  rollno;
    private String course;
    //adding attendence field is pending
    @OneToOne
    @JoinColumn(name="userID")
    private User student;
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
