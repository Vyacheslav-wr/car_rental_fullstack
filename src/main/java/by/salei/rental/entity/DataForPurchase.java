package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "data_for_purchase")
public class DataForPurchase extends BaseEntity {

    private String cardNumber;
    private String status;
}
