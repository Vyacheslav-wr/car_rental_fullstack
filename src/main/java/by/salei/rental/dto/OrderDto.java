package by.salei.rental.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDto {

    private Integer rental_id;
    private Integer car_id;
}
