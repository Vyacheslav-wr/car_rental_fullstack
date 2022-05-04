package by.salei.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRoleType role;
}
