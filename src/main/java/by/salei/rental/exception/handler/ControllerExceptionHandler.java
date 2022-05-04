package by.salei.rental.exception.handler;

import by.salei.rental.security.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(assignableTypes = {UserDetailsServiceImpl.class})
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ModelAndView handleIncorrectUserCredentials(UsernameNotFoundException ex) {
        ModelAndView mv = new ModelAndView("redirect:/login");
        mv.addObject("error", ex.getMessage());
        return mv;
    }
}
