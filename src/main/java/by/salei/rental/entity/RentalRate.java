package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "rental_rate")
public class RentalRate extends BaseEntity {

    private String measurements;
    private Integer amount;
    private Double cost;
    private Double costForKilometer;
}
