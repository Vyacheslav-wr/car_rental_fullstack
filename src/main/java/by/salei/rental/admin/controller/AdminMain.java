package by.salei.rental.admin.controller;

import by.salei.rental.repo.AuthAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminMain {

    private final AuthAccountRepository authAccountRepository;

    @GetMapping("")
    public ModelAndView getMainPage() {

        ModelAndView mv = new ModelAndView("admin/admin-main");

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(authAccountRepository.findByLogin(userName) != null) {
            mv.addObject("user", authAccountRepository.findByLogin(userName));
        }
        return mv;
    }
}
