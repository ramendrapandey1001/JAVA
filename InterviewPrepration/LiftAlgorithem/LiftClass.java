package JAVA.InterviewPrepration.LiftAlgorithem;

public class LiftClass {

    private String liftName;
    private Integer currentFloor;
    private Integer moveToFloor;
    private boolean isCalledFromInsideTheLift;
    private LiftDirection liftDirection;

    public LiftClass(String liftName, Integer currentFloor, Integer moveToFloor, boolean isCalledFromInsideTheLift, LiftDirection liftDirection) {
        this.liftName = liftName;
        this.currentFloor = currentFloor;
        this.moveToFloor = moveToFloor;
        this.isCalledFromInsideTheLift = isCalledFromInsideTheLift;
        this.liftDirection = liftDirection;
    }

    @Override
    public String toString() {
        return "LiftClass{" +
                "liftName='" + liftName + '\'' +
                ", currentFloor=" + currentFloor +
                ", moveToFloor=" + moveToFloor +
                ", isCalledFromInsideTheLift=" + isCalledFromInsideTheLift +
                ", liftDirection=" + liftDirection +
                '}';
    }
}
