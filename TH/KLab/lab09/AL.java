import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AL {
    private int V;
    private ArrayList <LinkedList <Integer> > adj;

    public AL(int v) {
        V = v;
        adj = new ArrayList <LinkedList <Integer >>();
        for (int i=0; i < v; ++i)
            adj.add(new LinkedList <Integer >());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for(Integer v: adj.get(i)){
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }

    public void input(Scanner sc){
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] component = line.split(" ");
            int i = Integer.valueOf(component[0]);
            for(int j = 1; j < component.length; j++)
                addEdge(i, Integer.valueOf(component[j]));
        }
    }

    public int numOfVertices() {
        return V;
    }

    public int numOfEdges() {
        int count = 0;
        for(int i = 0; i < V; i++) {
            count += adj.get(i).size();
        }
        return count / 2;
    }

    public void neighbor(int vertice) {
        for(int i: adj.get(vertice))
            System.out.print(i);
        System.out.println();
    }

    public boolean checkExistEdge(int vertice1, int vertice2) {
        return adj.get(vertice1).contains(vertice2);
    }

    public ArrayList<LinkedList<Integer>> getAdj() {
        return adj;
    }

    public boolean isReachable(int u, int v) {
        boolean[] visited = new boolean[adj.size()];
        return isReachable(u, v, visited);
    }

    public boolean isReachable(int current, int target, boolean[] visited) {
        visited[current] = true;

        if (current == target) {
            return true;
        }

        for (int neighbor : adj.get(current)) {
            if (!visited[neighbor] && isReachable(neighbor, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
