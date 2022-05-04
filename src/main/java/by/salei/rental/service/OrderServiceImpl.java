package by.salei.rental.service;

import by.salei.rental.entity.Car;
import by.salei.rental.entity.Order;
import by.salei.rental.entity.OrderStatus;
import by.salei.rental.entity.RentalRate;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.repo.OrderRepository;
import by.salei.rental.repo.RentalRateRepository;
import by.salei.rental.service.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRepository> implements OrderService {

    private final CarRepository carRepository;
    private final RentalRateRepository repository;
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Integer id, Integer rate_id) {

        Order order = new Order();

        Optional<Car> car = carRepository.findById(id);
        Optional<RentalRate> rentalRate = repository.findById(rate_id);

        if(car.isPresent() && rentalRate.isPresent()) {
            order.setCar(car.get());
            order.setRate(rentalRate.get());
            order.setStatus(OrderStatus.INPROGRESS);
            order.setDate(new Date());

            orderRepository.save(order);
        }

         return order;
    }
}
