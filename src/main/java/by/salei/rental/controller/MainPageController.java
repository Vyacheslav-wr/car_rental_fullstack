package by.salei.rental.controller;

import by.salei.rental.entity.Car;
import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final AuthAccountRepository repository;
    private final CarRepository carRepository;

    @GetMapping("/")
    public ModelAndView showMainPage() {

        ModelAndView mv = new ModelAndView("index");

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        List<Car> cars = carRepository.findDistinctByMark();

        mv.addObject("cars", cars);

        if(repository.findByLogin(userName) != null) {
            mv.addObject("user", repository.findByLogin(userName));
            if(repository.findByLogin(userName).getRole().getRole().toString().equals("ADMIN")) {
                mv.setViewName("admin/admin-main");
            }
        }

        return mv;
    }
}
