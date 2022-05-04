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
    private Double amount;
    private Double amountForKilometer;
}
