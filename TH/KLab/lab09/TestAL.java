import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TestAL {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("AL.txt"));
            Scanner sc = new Scanner(br);

            AL al = new AL(Integer.valueOf(sc.nextLine()));

            // a
            al.input(sc);
            al.printGraph();

            // b
            System.out.println(al.numOfVertices());

            // c
            System.out.println(al.numOfEdges());

            // d
            al.neighbor(2);

            // e
            System.out.println(al.checkExistEdge(1, 2));

            // cau9
            System.out.println(al.isReachable(0, 6));

        } catch(Exception e) {
            System.out.println(e);
            // System.err.println(e);
        }


    }
}