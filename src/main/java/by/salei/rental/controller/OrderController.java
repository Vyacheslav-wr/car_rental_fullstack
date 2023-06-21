package by.salei.rental.controller;

import by.salei.rental.dto.OrderDto;
import by.salei.rental.dto.OrderId;
import by.salei.rental.entity.*;
import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.repo.OrderRepository;
import by.salei.rental.repo.RentalRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository repository;
    private final RentalRateRepository rentalRateRepository;
    private final CarRepository carRepository;
    private final AuthAccountRepository authAccountRepository;
    private final static Double CAR_SPEED = 50.0;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto dto) {

        Optional<Car> car = carRepository.findById(dto.getCar_id());
        Optional<RentalRate> rentalRate = rentalRateRepository.findById(dto.getRental_id());
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(car.isPresent() && rentalRate.isPresent()) {
            if(authAccountRepository.findByLogin(userName) == null) {
                return new ResponseEntity<>("failed", HttpStatus.FORBIDDEN);
            }
            if(car.get().getStatus().equals(CarStatus.TAKEN)) {
                return new ResponseEntity<>("failed", HttpStatus.CONFLICT);
            }
            Order order = new Order();
            car.get().setStatus(CarStatus.TAKEN);

            order.setDate(new Date());
            order.setStatus(OrderStatus.INPROGRESS);
            order.setCar(car.get());
            order.setRate(rentalRate.get());
            order.setAuthAccount(authAccountRepository.findByLogin(userName));
            repository.save(order);
            return new ResponseEntity<>("successful", HttpStatus.OK);
        }

        throw new EntityNotFoundException();
    }

    @PostMapping("/finish")
    public ResponseEntity<String> finnishOrder(@RequestBody OrderId orderId) {

        Optional<Order> opt_order = repository.findById(orderId.getOrder_id());
        Double sum =  0.0;

        if(opt_order.isPresent()) {
            Order order = opt_order.get();
            sum = order.getRate().getCost();
            sum += CAR_SPEED * (new Date().getTime() - order.getDate().getTime())/360000000.0 * order.getRate().getCostForKilometer();
            order.setTotalSum(sum.toString());
            Car car = order.getCar();
            car.setStatus(CarStatus.FREE);
            carRepository.save(car);
            order.setStatus(OrderStatus.DONE);
            repository.save(order);
            return new ResponseEntity<>(sum.toString(), HttpStatus.OK);
        }

        throw new EntityNotFoundException();
    }
}
