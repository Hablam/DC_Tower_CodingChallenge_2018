package Elevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());
    private static int numberOfElevators = 1;

    public static void main(String[] args){
        logger.log(Level.INFO, "Starting Elevator.Elevator Service");
        logger.log(Level.INFO, "Starting Elevator.Elevator Controller");
        Elevator_Controller elevatorController = new Elevator_Controller(numberOfElevators);
        new Thread(elevatorController).start();
        SpringApplication.run(Main.class, args);




        /*Elevator.Request requestOne = new Elevator.Request(0, 27, Elevator.Elevator_Direction.UP);
        elevatorController.addRequest(requestOne);
        Elevator.Request requestTwo = new Elevator.Request(5, 0);
        elevatorController.addRequest(requestTwo);
        Elevator.Request requestThree = new Elevator.Request(12, 0);
        elevatorController.addRequest(requestThree);
        Elevator.Request requestFour = new Elevator.Request(0, 18);
        elevatorController.addRequest(requestFour);
        Elevator.Request requestFive = new Elevator.Request(0, 34);
        elevatorController.addRequest(requestFive);
        Elevator.Request requestSix = new Elevator.Request(17, 0);
        elevatorController.addRequest(requestSix);
        Elevator.Request requestSeven = new Elevator.Request(0, 24);
        elevatorController.addRequest(requestSeven);
        Elevator.Request requestEight = new Elevator.Request(8, 0);
        elevatorController.addRequest(requestEight);
        Elevator.Request requestNine = new Elevator.Request(0, 46);
        elevatorController.addRequest(requestNine);
        Elevator.Request requestTen = new Elevator.Request(0, 4);
        elevatorController.addRequest(requestTen);*/



    }
}
