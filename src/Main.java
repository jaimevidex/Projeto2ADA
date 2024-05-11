import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        String[] token = in.readLine().split(" ");
        int length = Integer.parseInt(token[0]);
        int width = Integer.parseInt(token[1]);
        int robotDiameter = Integer.parseInt(in.readLine());
        int nrBeams = Integer.parseInt(in.readLine());
        int[] beams = new int[nrBeams+2];
        beams[0] = length + 1;
        for (int i = 1; i < nrBeams+1; i++) {
            token = in.readLine().split(" ");
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);
            beams[i] = y * (length) + x;
        }
        beams[nrBeams+1] = width * length - 1;
        /*for (int beam : beams) {
            System.out.println("x: " + beam % length + " y: " + beam / length);
        }*/
        RobotEscapeSystem sys = new RobotEscapeSystem(length, width, robotDiameter, beams);
        if (sys.escape()) {
            System.out.println("Rob manages to escape!");
        } else {
            System.out.println("Impossible to escape");
        }
    }
}