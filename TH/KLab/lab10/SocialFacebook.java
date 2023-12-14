import java.util.*;
class IntegerDouble {
    private Integer s, d;

    public IntegerDouble(Integer s, Integer d) {
        this.s = s;
        this.d = d;
    }
    public Integer getSource() {
        return s;
    }
    public Integer getDestination() {
        return d;
    }
    @Override
    public String toString() {
        return  s + " " + d;
    }
}
public class SocialFacebook {
    private Vector<IntegerDouble> edges;

    public SocialFacebook() {
        edges = new Vector<IntegerDouble>();
    }
    public void addEdge(int u, int v) {
        edges.add(new IntegerDouble(u, v));
    }
    public int numberOfEdges() {
        return edges.size();
    }
    public void readData(Scanner sc) {
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] values = line.split(" ");
            addEdge(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        }
    }
    public int numberOfVertices() {
        Set<Integer> check = new HashSet<>();
        for(IntegerDouble tmp: edges) {
            check.add((tmp.getSource()));
            check.add((tmp.getDestination()));
        }
        return check.size();
    }
    public static ArrayList<LinkedList<Integer>> adj;
    public void convert() {
        adj = new ArrayList<>();
        for(int i = 0; i < numberOfVertices(); i++)
            adj.add(new LinkedList<>());
        for(IntegerDouble tmp: edges) {
            adj.get(tmp.getSource()).add(tmp.getDestination());
            // adj.get(tmp.getDestination()).add(tmp.getSource());
        }
    }
    public int countCompoment() {
        convert();
        return countCompoment(adj);
    }
    private int countCompoment(ArrayList<LinkedList<Integer>> adj1) {
        int count = 0;
        boolean[] visited = new boolean[adj1.size()];
        for (int vertex = 0; vertex < adj1.size(); vertex++) {
            if (!visited[vertex]) {
                dfs(vertex, visited, adj1);
                count++;
            }
        }
        return count;
    }
    public void dfs(int vertex, boolean[] visited, ArrayList<LinkedList<Integer>> adj1) {
        visited[vertex] = true;
        for (int neighbor : adj1.get(vertex))
            if (!visited[neighbor])
                dfs(neighbor, visited, adj1);
    }
    private HashMap<Integer, Integer> userHasMostFriends(ArrayList<LinkedList<Integer>> AL) {
        HashMap<Integer, Integer> mostFriends = new HashMap<Integer,Integer>();
        int max = 0;
        for(int i = 0; i < AL.size(); i++)
            if(AL.get(i).size() > max)
                max = AL.get(i).size();
        for(int i = 0; i < AL.size(); i++)
            if(AL.get(i).size() == max)
                mostFriends.put(i, max);
        return mostFriends;
    }
    public HashMap<Integer, Integer> userHasMostFriends() {
        convert();
        return userHasMostFriends(adj);
    }
    private LinkedList<Integer> mutualFriends(Integer u, Integer v, ArrayList<LinkedList<Integer>> AL) {
        LinkedList<Integer> friends = new LinkedList<>();
            for(int neighbor1: AL.get(u))
                for(int neighbor2: AL.get(v))
                    if(neighbor1 == neighbor2)
                        friends.add(neighbor1);
        return friends;
    }
    public LinkedList<Integer> mutualFriends(Integer u, Integer v) {
        convert();
        return mutualFriends(u, v, adj);
    }
    public void printGraph() {
        convert();
        for(int i = 0; i <adj.size() ; i++) {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for(Integer v: adj.get(i))
                System.out.print(" -> " + v);
            System.out.println();
        }
    }
}