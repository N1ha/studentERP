package dev.erp.student.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRegister {
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
}
