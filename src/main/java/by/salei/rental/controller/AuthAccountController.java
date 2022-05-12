package by.salei.rental.controller;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.entity.AuthAccount;
import by.salei.rental.entity.OrderStatus;
import by.salei.rental.entity.Profile;
import by.salei.rental.exception.UserAlreadyExist;
import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.CarRepository;
import by.salei.rental.repo.OrderRepository;
import by.salei.rental.service.api.AuthAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.Encoder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authAccount")
public class AuthAccountController {

    private final AuthAccountService service;
    private final OrderRepository orderRepository;
    private final AuthAccountRepository repository;
    private final CarRepository carRepository;
    private final PasswordEncoder encoder;

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

    @PostMapping("/update")
    public ModelAndView updateUserAccount(AuthAccountReg account) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        AuthAccount aa = repository.findByLogin(userName);
        ModelAndView mv = new ModelAndView("redirect:/authAccount/" + aa.getId());
        Profile p = aa.getProfile();

        if(account.getPassword() != null) {
            aa.setPassword(encoder.encode(account.getPassword()));
        }
        p.setFirstName(account.getFirstName());
        p.setLastName(account.getLastName());
        p.setMiddleName(account.getMiddleName());
        p.setPhoneNumber(account.getPhoneNumber());

        aa.setLogin(account.getUsername());
        aa.setEmail(account.getEmail());
        aa.setProfile(p);
        repository.save(aa);

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
