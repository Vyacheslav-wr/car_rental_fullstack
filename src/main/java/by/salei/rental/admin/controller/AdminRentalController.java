package by.salei.rental.admin.controller;

import by.salei.rental.entity.RentalRate;
import by.salei.rental.repo.RentalRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminRentalController {

    private final RentalRateRepository repository;

    @GetMapping("/rental")
    public ModelAndView getRentals() {

        ModelAndView mv = new ModelAndView("/admin/AdminRentalPage");

        mv.addObject("rentals", repository.findAll());

        return mv;
    }

    @PostMapping("/rental/create")
    public ModelAndView createRental(RentalRate rentalRate) {

        ModelAndView mv = new ModelAndView("redirect:/admin/rental");

        repository.save(rentalRate);
        return mv;
    }

    @GetMapping("/rental/{id}")
    public ModelAndView getRental(@PathVariable(name = "id") Integer id) {
        ModelAndView mv = new ModelAndView();

        Optional<RentalRate> rentalRate = repository.findById(id);

        rentalRate.ifPresent(rate -> mv.addObject("rental", rate));

        return mv;
    }

    @PostMapping("/rental{id}/update")
    public ModelAndView updateRental(@PathVariable(name = "id") Integer id, RentalRate rate) {

        ModelAndView mv = new ModelAndView();

        Optional<RentalRate> rentalRate = repository.findById(id);

        if(rentalRate.isPresent()) {
            RentalRate rr = rentalRate.get();
            rr.setAmount(rate.getAmount());
            rr.setCostForKilometer(rate.getCostForKilometer());
            rr.setCost(rate.getCost());
            rr.setMeasurements(rate.getMeasurements());
            repository.save(rr);
        }

        return mv;
    }
}
