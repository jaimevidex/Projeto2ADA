import java.util.LinkedList;

public class RobotEscapeSystem {

    private int width;
    private int length;
    private int robotDiameter;
    LinkedList<Integer>[] graph;

    public RobotEscapeSystem(int width, int length, int robotDiameter, int[] hasBeam) {
        this.width = width;
        this.length = length;
        this.robotDiameter = robotDiameter;
        createGraph(hasBeam);
    }

    private void createGraph(int[] hasBeam) {

    }


    public boolean escape() {
        return false;
    }
}
