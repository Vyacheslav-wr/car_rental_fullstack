package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "driver_license")
public class DriverLicense extends BaseEntity {

    private String licenseIdentity;

    @Enumerated(EnumType.STRING)
    private LicenseCategoryType licenseCategory;

    @Enumerated(EnumType.STRING)
    private LicenseCategoryStatus licenseStatus;
}
