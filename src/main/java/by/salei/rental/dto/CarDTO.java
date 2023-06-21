package by.salei.rental.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CarDTO {

    private String mark;

    private Integer mileage;

    private Boolean booster;

    private Boolean charger;

    private Boolean toning;

    private Boolean cooler;

    private String status;

    private Boolean backCamera;

    private Boolean climateControl;

    private String carType;
}
