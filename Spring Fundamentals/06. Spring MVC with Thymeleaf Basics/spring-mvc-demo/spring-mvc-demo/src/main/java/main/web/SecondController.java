package main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
@RequestMapping("/info2")
public class SecondController {

    // Variant 1: use ModelAndView class
    @GetMapping("/time-now")
    public ModelAndView getInfo() {

        ModelAndView modelAndView = new ModelAndView();

        String timeNowMessage = "The current time is " + LocalTime.now();
        modelAndView.addObject("message", timeNowMessage);

        // We choose which HTML page we want to show
        modelAndView.setViewName("info");

        return modelAndView;
    }

    // Variant 2: use Model class
    @GetMapping("/time-now2")
    public String getInfo2(Model model) {

        String timeNowMessage = "The current time is " + LocalTime.now();

        model.addAttribute("message", timeNowMessage);

        return "info";
    }
}
