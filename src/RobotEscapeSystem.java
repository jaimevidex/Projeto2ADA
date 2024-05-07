import UnionFind.UnionFindInArray;
import UnionFind.UnionFind;

public class RobotEscapeSystem {

    private int width;
    private int length;
    private int robotDiameter;
    private int[] beams;
    private UnionFind uf;

    public RobotEscapeSystem(int length, int width, int robotDiameter, int[] beams) {
        this.width = width;
        this.length = length;
        this.robotDiameter = robotDiameter;
        this.beams = beams;
        uf = new UnionFindInArray(beams.length);
    }

    public boolean escape() {
        for (int i = 0; i < beams.length; i++) {
            int x1 = beams[i] % length;
            int y1 = beams[i] / length + 1;

        }
        return true;
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
