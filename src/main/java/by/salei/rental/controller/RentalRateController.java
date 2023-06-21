package by.salei.rental.controller;

import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.RentalRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/rates")
@RequiredArgsConstructor
@Controller
public class RentalRateController {

    private final RentalRateRepository repository;
    private final AuthAccountRepository authAccountRepository;

    @GetMapping("/catalog")
    public ModelAndView getAllRates() {

        ModelAndView mv = new ModelAndView("rentals");

        mv.addObject("rentals", repository.findAll());
        mv.addObject("measurements", repository.findDistinctMeasurement());
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(authAccountRepository.findByLogin(userName) != null) {
            mv.addObject("user", authAccountRepository.findByLogin(userName));
        }

        return mv;
    }
}
