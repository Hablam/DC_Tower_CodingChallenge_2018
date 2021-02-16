package Elevator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
@RestController
public class RESTController {
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getFloorUpdate")
    ArrayList<Integer> getFloorUpdate(){ return Elevator_Controller.getAllElevatorFloors(); }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getTargetUpdate")
    ArrayList<Integer> getTargetUpdate(){ return Elevator_Controller.getAllTargetFloors(); }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/sendRequest")
    public boolean sendRequest(@RequestBody HashMap<String, String> requestData){
        Elevator_Controller.addRequest(new Request(Integer.parseInt((requestData.get("startFloor"))), Integer.parseInt(requestData.get("targetFloor"))));
        System.out.println(requestData.get("startFloor") + " " +requestData.get("targetFloor"));
        return true;
    }
}
