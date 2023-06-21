package by.salei.rental.controller;

import by.salei.rental.entity.AuthAccount;
import by.salei.rental.entity.CarStatus;
import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.repo.RentalRateRepository;
import by.salei.rental.service.api.AuthAccountService;
import by.salei.rental.service.api.CarService;
import by.salei.rental.service.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final CarRepository repository;
    private final RentalRateRepository rentalRepository;
    private final OrderService orderService;
    private final AuthAccountRepository authAccountRepository;
    private final AuthAccountService authAccountService;

    @GetMapping("/catalog")
    public ModelAndView getAllMarks() {

        ModelAndView mv = new ModelAndView("cars-to-order");

        mv.addObject("cars", repository.findAllByStatus(CarStatus.FREE));
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        AuthAccount authAccount = authAccountService.findUserByLogin(userName);

        mv.addObject("user", authAccount);

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getCar(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("car");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(authAccountRepository.findByLogin(userName) != null) {
            mv.addObject("user", authAccountRepository.findByLogin(userName));
        }

        if(carService.getById(id).isPresent()) {
            mv.addObject("car", carService.getById(id).get());
            mv.addObject("rentals", rentalRepository.findAll());
        }
        else {
            throw new EntityNotFoundException();
        }

        return mv;
    }

    @PostMapping("/car/{id}/rent")
    public ModelAndView rentACar(@PathVariable(name = "id") Integer id, @RequestParam(name = "rate_id") Integer rate_id) {

        if(repository.findById(id).isEmpty() || rentalRepository.findById(rate_id).isEmpty()) {
            throw new EntityNotFoundException();
        }

       orderService.createOrder(id, rate_id);

        return new ModelAndView("redirect:/catalog");
    }
}
