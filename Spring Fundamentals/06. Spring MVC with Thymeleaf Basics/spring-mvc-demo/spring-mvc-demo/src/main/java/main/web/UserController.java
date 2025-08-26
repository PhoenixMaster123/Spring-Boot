package main.web;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserDetailsPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        User user = userService.getUserById(id);

        modelAndView.setViewName("user-details");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllUsersPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> allUsers = userService.getAllUsers();
        modelAndView.addObject("users", allUsers);
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
