package Elevator;


public class Request {
    private int startFloor;
    private int destinationFloor;
    private Elevator_Direction direction;

    public Request(int startFloor, int destinationFloor, Elevator_Direction direction){
        this.startFloor = startFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
    }

    public Request(int startFloor, int destinationFloor){
        this.startFloor = startFloor;
        this.destinationFloor = destinationFloor;
        if(destinationFloor-startFloor>0){
            this.direction = Elevator_Direction.UP;
        }
        else{
            this.direction = Elevator_Direction.DOWN;
        }
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public Elevator_Direction getDirection() {
        return direction;
    }
}
