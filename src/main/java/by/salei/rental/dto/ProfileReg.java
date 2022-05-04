package by.salei.rental.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProfileReg {

    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String age;
}
