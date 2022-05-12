package by.salei.rental.mapper;

import by.salei.rental.dto.CarDTO;
import by.salei.rental.entity.Car;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CarMapper {

    Car convert(CarDTO dto);
}
