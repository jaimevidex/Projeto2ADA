import UnionFind.UnionFindInArray;
import UnionFind.UnionFind;

public class RobotEscapeSystem {

    private int width;
    private final int length;
    private final int robotDiameter;
    private final int[] beams;

    public RobotEscapeSystem(int length, int width, int robotDiameter, int[] beams) {
        this.width = width;
        this.length = length;
        this.robotDiameter = robotDiameter;
        this.beams = beams;
    }

    public boolean escape() {
        UnionFind uf = new UnionFindInArray(beams.length);
        for (int i = 1; i < beams.length-1; i++) {
            int x1 = beams[i] % length;
            int y1 = beams[i] / length;
            if (y1 < robotDiameter && uf.find(i) != uf.find(0)) {
                uf.union(uf.find(0), uf.find(i));
            }
            if (y1 > width - robotDiameter && uf.find(i) != uf.find(beams.length - 1)) {
                uf.union(uf.find(beams.length - 1), uf.find(i));
            }
            for (int j = i+1; j < beams.length-1; j++) {
                int x2 = beams[j] % length;
                int y2 = beams[j] / length;
                if (getDistance(x1, y1, x2, y2) < robotDiameter && uf.find(i) != uf.find(j)){
                    uf.union(uf.find(i), uf.find(j));
                }
            }
        }
        return uf.find(0) != uf.find(beams.length-1);
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}