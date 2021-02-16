package Elevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());
    private static int numberOfElevators = 7;

    public static void main(String[] args){
        logger.log(Level.INFO, "Starting Elevator.Elevator Service");
        logger.log(Level.INFO, "Starting Elevator.Elevator Controller");
        Elevator_Controller elevatorController = new Elevator_Controller(numberOfElevators);
        new Thread(elevatorController).start();
        SpringApplication.run(Main.class, args);



        Request requestOne = new Request(0, 27, Elevator_Direction.UP);
        elevatorController.addRequest(requestOne);
        Request requestTwo = new Request(5, 0);
        elevatorController.addRequest(requestTwo);
        Request requestThree = new Request(12, 0);
        elevatorController.addRequest(requestThree);
        Request requestFour = new Request(0, 18);
        elevatorController.addRequest(requestFour);
        Request requestFive = new Request(0, 34);
        elevatorController.addRequest(requestFive);
        Request requestSix = new Request(17, 0);
        elevatorController.addRequest(requestSix);
        Request requestSeven = new Request(0, 24);
        elevatorController.addRequest(requestSeven);
        Request requestEight = new Request(8, 0);
        elevatorController.addRequest(requestEight);
        Request requestNine = new Request(0, 46);
        elevatorController.addRequest(requestNine);
        Request requestTen = new Request(0, 4);
        elevatorController.addRequest(requestTen);



    }
}
