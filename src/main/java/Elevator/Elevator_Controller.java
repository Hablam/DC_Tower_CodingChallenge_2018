package Elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Elevator_Controller implements Runnable {
    private final static Logger logger = Logger.getLogger(Elevator_Controller.class.getName());

    private static List<Elevator> allElevators = new ArrayList<>();
    private static Queue<Request> requestQueue;

    public Elevator_Controller (int numberOfElevators){
        for(int i = 0; i<numberOfElevators; i++){
            Elevator tmpElevator = new Elevator();
            allElevators.add(tmpElevator);
            Thread tmpThread = new Thread(tmpElevator, "Elevator " + i);
            tmpThread.start();
        }
        this.requestQueue = new LinkedBlockingQueue<>();
    }

    public static ArrayList<Integer> getAllElevatorFloors(){
        ArrayList<Integer> elevatorFloors = new ArrayList<>();
        for(Elevator elevator : allElevators){
            elevatorFloors.add(elevator.getCurrent_Floor());
        }
        return elevatorFloors;
    }

    public static ArrayList<Integer> getAllTargetFloors(){
        ArrayList<Integer> elevatorTargets = new ArrayList<>();
        for(Elevator elevator : allElevators){
            elevatorTargets.add(elevator.getTargetFloor());
        }
        return elevatorTargets;
    }

    public static void addRequest(Request request){
        requestQueue.add(request);
    }

    public Elevator findAvailableElevator(Request request){
        Elevator suitableElevator = null;
        int minFloorDistance = Integer.MAX_VALUE;
        for (Elevator elevator: allElevators) {
            if(elevator.getDirection() == Elevator_Direction.STILL && elevator.getElevatorPathSize() == 0){
                int tmpFloorDistance = Math.abs(request.getStartFloor()- elevator.getCurrent_Floor());
                if(tmpFloorDistance < minFloorDistance){
                    minFloorDistance = tmpFloorDistance;
                    suitableElevator = elevator;
                }
            }
        }
        return suitableElevator;
    }

    @Override
    public void run() {
        while(true) {
            if(requestQueue.size()>0){
                Request newRequest = requestQueue.remove();
                Elevator availabeElevator = null;
                while(availabeElevator == null){
                    availabeElevator = findAvailableElevator(newRequest);
                }
                logger.log(Level.INFO, "Found Elevator.Elevator " + allElevators.indexOf(availabeElevator));
                availabeElevator.moveToFloor(newRequest.getStartFloor(), newRequest.getDestinationFloor());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
