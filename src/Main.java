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
        int[] hasBeam = new int[length*width];
        for (int i = 0; i < nrBeams; i++) {
            token = in.readLine().split(" ");
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);
            hasBeam[x*length + y] = 1;
        }
        System.out.println(Arrays.toString(hasBeam));
        RobotEscapeSystem sys = new RobotEscapeSystem(length, width, robotDiameter, hasBeam);
        if (sys.escape()) {
            System.out.println("Rob manages to escape!");
        } else {
            System.out.println("Impossible to escape");
        }
    }
}
// IF WE WANT TO USE THE HASBEAM AS AN ARRAY
/*  */