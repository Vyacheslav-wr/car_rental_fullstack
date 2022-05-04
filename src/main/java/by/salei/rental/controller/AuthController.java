package by.salei.rental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) String error) {

        ModelAndView mv = new ModelAndView("login");

        if(error != null) {
            mv.addObject("error", "true");
        }

        return mv;
    }
    @GetMapping("/register")
    public ModelAndView register(@RequestParam(name = "error", required = false) String error) {

        ModelAndView mv  = new ModelAndView("register");

        if(error != null) {
            mv.addObject("error", "true");
        }

        return mv;
    }
}
