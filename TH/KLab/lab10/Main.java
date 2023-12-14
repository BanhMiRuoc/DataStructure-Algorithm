import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        SocialFacebook n = new SocialFacebook();
        try {
            Scanner sc = new Scanner(new FileReader("facebook_combined.txt"));
            // Scanner sc = new Scanner(new FileReader("t.txt"));
            n.readData(sc);
            sc.close();
            System.out.println(n.numberOfEdges());
            System.out.println(n.numberOfVertices());
            System.out.println(n.countCompoment());
            System.out.println(n.userHasMostFriends());
            System.out.println(n.mutualFriends(4, 0));
            // n.printGraph();
        }
        catch (Exception err) {

        }
    }
}
