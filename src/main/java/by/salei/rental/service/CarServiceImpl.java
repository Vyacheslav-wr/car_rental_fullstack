package by.salei.rental.service;

import by.salei.rental.entity.Car;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.service.api.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car, CarRepository> implements CarService {
}
