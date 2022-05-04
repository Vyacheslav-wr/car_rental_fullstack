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
@Table(name = "car")
public class Car extends BaseEntity {

    private String mark;
    private Integer mileage;
    private Boolean booster;
    private Boolean charger;
    private Boolean toning;
    private Boolean cooler;

    @Enumerated(EnumType.STRING)
    private CarStatus status;
    private Boolean backCamera;
    private Boolean climateControl;

    @Enumerated(EnumType.STRING)
    private CarType carType;
}
