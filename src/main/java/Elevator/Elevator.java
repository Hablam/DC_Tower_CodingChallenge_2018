package Elevator;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Elevator implements Runnable{
    private final static Logger logger = Logger.getLogger(Elevator_Controller.class.getName());

    private int currentFloor = 0;
    private Elevator_Direction direction = Elevator_Direction.STILL;
    private Queue<Integer> elevatorPath = new LinkedBlockingQueue<>();
    private int targetFloor = 0;

    public int getCurrent_Floor() {
        return currentFloor;
    }

    public int getTargetFloor(){ return targetFloor;}

    public Elevator_Direction getDirection(){
        return direction;
    }

    public int getElevatorPathSize(){
        return elevatorPath.size();
    }

    public void moveToFloor(int startFloor, int targetFloor){
        if(direction == Elevator_Direction.STILL) {
            if(currentFloor == startFloor){
                elevatorPath.add(targetFloor);
            }
            else{
                elevatorPath.add(startFloor);
                elevatorPath.add(targetFloor);
            }
        }
        else {
            logger.log(Level.WARNING, "Elevator.Elevator already moving");
        }
    }

    @Override
    public void run() {
        logger.log(Level.INFO, Thread.currentThread().getName() + " running");
        while(true) {
            if(elevatorPath.size()>0 && currentFloor == targetFloor){
                targetFloor = elevatorPath.remove();
                if(targetFloor-currentFloor>0){
                    this.direction = Elevator_Direction.UP;
                }
                else{
                    this.direction = Elevator_Direction.DOWN;
                }
            }
            if ((direction != Elevator_Direction.STILL) && (currentFloor != targetFloor)) {
                switch (direction) {
                    case UP -> currentFloor++;
                    case DOWN -> currentFloor--;
                }
                logger.log(Level.INFO, Thread.currentThread().getName() + " Floor: " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (currentFloor == targetFloor) {
                direction = Elevator_Direction.STILL;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
