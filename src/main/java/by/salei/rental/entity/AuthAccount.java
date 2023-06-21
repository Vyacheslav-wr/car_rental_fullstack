package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "auth_account")
public class AuthAccount extends BaseEntity {

    private String login;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "data_for_purchase_id")
    private DataForPurchase dataForPurchase;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private UserRole role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "license_id")
    private DriverLicense license;
}
