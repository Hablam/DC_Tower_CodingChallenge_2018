package Elevator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Web_Controller {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("elevatorOne", Integer.toString(1));
        return "index";
    }
}
