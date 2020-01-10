package kamenev.controller;

import kamenev.model.User;
import kamenev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер для отображения собственного профиля юзера
 * С возможностью менять его и удалять
 */

@RequestMapping(value = "/profile")
@Controller
public class ProfileController {
    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getById(0);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }
}
