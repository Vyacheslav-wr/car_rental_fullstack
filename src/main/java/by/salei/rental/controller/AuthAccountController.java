package by.salei.rental.controller;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.exception.UserAlreadyExist;
import by.salei.rental.service.api.AuthAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authAccount")
public class AuthAccountController {

    private final AuthAccountService service;

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

        mv.setViewName("redirect:/authAccount/login");
        return mv;
    }
}
