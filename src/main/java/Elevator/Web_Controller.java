package Elevator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Web_Controller {

    @GetMapping("/")
    //Setting the names of the Elevators on the Website
    public String index(Model model){
        model.addAttribute("elevatorOne", "Elevator One");
        model.addAttribute("elevatorTwo", "Elevator Two");
        model.addAttribute("elevatorThree", "Elevator Three");
        model.addAttribute("elevatorFour", "Elevator Four");
        model.addAttribute("elevatorFive", "Elevator Five");
        model.addAttribute("elevatorSix", "Elevator Six");
        model.addAttribute("elevatorSeven", "Elevator Seven");
        return "index";
    }
}
