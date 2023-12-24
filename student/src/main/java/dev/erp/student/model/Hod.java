package dev.erp.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hodId;
    private String department;
    @OneToOne
    @JoinColumn(name="userID")
    private User hod;

    public int getHodId() {
        return hodId;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHod(User hod) {
        this.hod = hod;
    }
}
