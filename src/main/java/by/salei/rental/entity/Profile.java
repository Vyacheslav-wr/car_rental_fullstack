package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "profile")
public class Profile extends BaseEntity {

    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private Integer age;
}
