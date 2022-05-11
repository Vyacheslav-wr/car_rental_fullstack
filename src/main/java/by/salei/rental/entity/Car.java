package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Order> order;
}
