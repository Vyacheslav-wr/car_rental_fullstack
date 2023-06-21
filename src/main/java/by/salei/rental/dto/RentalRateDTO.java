package by.salei.rental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalRateDTO {


    private String measurements;

    private Integer amount;

    private Double cost;

    private Double costForKilometer;
}
