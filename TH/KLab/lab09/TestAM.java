import java.io.*;
import java.util.Scanner;

public class TestAM {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("AM.txt"));
            Scanner sc = new Scanner(br);

            AM am = new AM(sc.nextInt());

            // a
            am.input(sc);
            // am.printGraph();

            // b
            // System.out.println(am.numOfVertices());

            // c
            // System.out.println(am.numOfEdges());

            // d
            // am.neighbor(2);

            // e
            // System.out.println(am.checkExistEdge(1, 2));

            // ex4
            // AL al = am.convertToAL();
            // a
            // al.input(sc);
            // al.printGraph();
            
            // b
            // System.out.println(al.numOfVertices());

            // c
            // System.out.println(al.numOfEdges());

            // d
            // al.neighbor(2);

            // e
            // System.out.println(al.checkExistEdge(1, 2));

            // BFS
            // System.out.println();
            am.BFS(0);

            // DFS_re
            System.out.println();
            am.DFS(0);

            // DFS_stack
            System.out.println();
            am.DFS_stack(0);

            // cau9
            System.out.println();
            System.out.println(am.isReachable(0, 6));
        } catch(Exception e) {
            System.out.println(e);
            // System.err.println(e);
        }
    }
}
