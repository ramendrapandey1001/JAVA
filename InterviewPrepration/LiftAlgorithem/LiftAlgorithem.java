package JAVA.InterviewPrepration.LiftAlgorithem;

import java.util.*;

public class LiftAlgorithem {

    static List <LiftClass> lifts = new ArrayList<>();
    static Integer numberOfFloors = 12;
    static Integer numberOfLifts = 6;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Which floor to go");
        Integer floorToMove = scanner.nextInt();
        System.out.println("Are you inside the lift?");
        boolean isCalledFromInsideTheLift = scanner.nextBoolean();

     //   liftCall(isCalledFromInsideTheLift, floorToMove);

        randomizeLifts();
    }

    public static Integer [] liftCall( boolean isCalledFromInsideTheLift, Integer floorToMove){
        Integer currentFloorNumber = null;
        Integer[] result = new Integer[2];
        if(!isCalledFromInsideTheLift){
            System.out.println("Which floor are you on?");
            currentFloorNumber = scanner.nextInt();
        }
        if(currentFloorNumber == null){
            result[0] = currentFloorNumber;
            result[1] = floorToMove;
            return result;
        }
        return new Integer[2];
    }

    public static void randomizeLifts(){

        for(int i = 1; i <= numberOfLifts; i++){

            Random random = new Random();
           int currentFloor = random.nextInt(numberOfFloors) + 1;
           int moveToFloor = random.nextInt(numberOfFloors) + 1;
           LiftDirection liftDirection = (moveToFloor - currentFloor >= 0) ? ((moveToFloor - currentFloor > 0) ? LiftDirection.Up : LiftDirection.Static)  : LiftDirection.Down;
           LiftClass tempLift = new LiftClass("Lift-" + i, currentFloor, moveToFloor, random.nextBoolean(), liftDirection);
           lifts.add(tempLift);
        }

        for(LiftClass lift : lifts) {
            System.out.println(lift);
        }
    }
}
