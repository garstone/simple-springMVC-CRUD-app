package kamenev.controller;

import kamenev.model.User;
import kamenev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/signup")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        return getModelAndView(user, userService);
    }

    static ModelAndView getModelAndView(@ModelAttribute("user") User user, UserService userService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        if (!userService.create(user)) {
            modelAndView.addObject("error", "true");
            modelAndView.setViewName("redirect:/users/add");
        }
        return modelAndView;
    }
}
