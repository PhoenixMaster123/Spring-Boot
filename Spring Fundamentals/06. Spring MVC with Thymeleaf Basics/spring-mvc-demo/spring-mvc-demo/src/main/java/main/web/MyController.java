package main.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class MyController {

    private Map<Integer, String> map = Map.of(
            1, "Ivan",
            2, "Gosho",
            3, "Hristo"
    );

    @GetMapping("/time-now")
    public String getTimeNow() {
        return "The current time is " + LocalTime.now();
    }

    @GetMapping("/day-of-week")
    public String getDayOfWeek() {
        return "Today is " + LocalDateTime.now().getDayOfWeek().name();
    }

    @GetMapping("/users/{id}")
    public String getUsernameById(@PathVariable int id) {
        return map.get(id);
    }
}
