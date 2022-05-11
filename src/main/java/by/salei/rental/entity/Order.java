package by.salei.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "order_table")
public class Order extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_account_id")
    private AuthAccount authAccount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id")
    private RentalRate rate;

    private String totalSum;

    private Date date;
}
