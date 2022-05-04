package by.salei.rental.controller;

import by.salei.rental.entity.Car;
import by.salei.rental.entity.CarStatus;
import by.salei.rental.entity.Order;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.repo.RentalRateRepository;
import by.salei.rental.service.api.CarService;
import by.salei.rental.service.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class CarController {

    private final CarService carService;
    private final CarRepository repository;
    private final RentalRateRepository rentalRepository;
    private final OrderService orderService;

//    @GetMapping()
//    public ModelAndView getAllMarks() {
//
//        ModelAndView mv = new ModelAndView();
//
//        Iterable<Car> cars = repository.findAll();
//
//        mv.addObject("cars", cars);
//
//        return mv;
//    }

    @GetMapping("/car/{id}")
    public ModelAndView getCar(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView();

        Optional<Car> car = carService.getById(id);

        mv.addObject("cars", car);

        return mv;
    }

    @GetMapping("")
    public ModelAndView getAllFreeCars() {

        ModelAndView mv = new ModelAndView();

        List<Car> cars = repository.findAllByStatus(CarStatus.FREE.toString());

        mv.addObject("cars", cars);

        return mv;
    }

    @GetMapping("/car/rent")
    public ModelAndView rentACar(@RequestParam(name = "id") Integer id, @RequestParam(name = "rate_id") Integer rate_id) {

        if(repository.findById(id).isEmpty() || rentalRepository.findById(rate_id).isEmpty()) {
            throw new EntityNotFoundException();
        }

        Order order = orderService.createOrder(id, rate_id);

        return new ModelAndView("redirect:/catalog");
    }
}
