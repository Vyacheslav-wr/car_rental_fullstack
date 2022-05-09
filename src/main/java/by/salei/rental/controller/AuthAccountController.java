package by.salei.rental.controller;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.entity.OrderStatus;
import by.salei.rental.exception.UserAlreadyExist;
import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.repo.OrderRepository;
import by.salei.rental.service.api.AuthAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authAccount")
public class AuthAccountController {

    private final AuthAccountService service;
    private final OrderRepository orderRepository;
    private final AuthAccountRepository repository;
    private final CarRepository carRepository;

    @PostMapping("/create")
    public ModelAndView createAuthAccount(AuthAccountReg aar) {

        ModelAndView mv = new ModelAndView();

        try {
            service.registerNewUser(aar);
        }
        catch (UserAlreadyExist ex) {
            mv.setViewName("register");
            mv.addObject("error", "true");
            return mv;
        }

        mv.setViewName("redirect:/auth/login");
        return mv;
    }

    @GetMapping("/{id}/orders")
    public ModelAndView showAllOrders(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("user-orders");
        mv.addObject("orders", orderRepository.findAllByAuthAccountIdAndStatus(id, OrderStatus.INPROGRESS));
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(repository.findByLogin(userName) != null) {
            mv.addObject("user", repository.findByLogin(userName));
        }

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getAuthAccount(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("auth-account");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(repository.findByLogin(userName) != null) {
            mv.addObject("user", repository.findByLogin(userName));
        }

        return mv;
    }
}
