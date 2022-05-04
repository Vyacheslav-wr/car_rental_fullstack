package by.salei.rental.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AuthAccountReg {

    private String username;
    private String password;
    private String repeat_password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String middleName;
    private Integer age;
}
