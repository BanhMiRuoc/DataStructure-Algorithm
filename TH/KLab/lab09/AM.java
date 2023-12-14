import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class AM {
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public AM(int vertices){
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public void setEdge(int vertexSource , int vertexDestination ,int weight){
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } catch (ArrayIndexOutOfBoundsException indexBounce){
            System.out.println("The vertex is invalid");
        }
    }

    public int getEdge(int vertexSource , int vertexDestination){
        try{
            return adj[vertexSource][vertexDestination];
        } catch (ArrayIndexOutOfBoundsException indexBounce){
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    public void printGraph(){
        for(int i = 0; i < NUMBER_OF_VERTICES; i++){
            for(int j = 0;j < NUMBER_OF_VERTICES; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void input(Scanner sc){
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                setEdge(i, j, sc.nextInt());
            }
        }
    }

    public int numOfVertices() {
        return NUMBER_OF_VERTICES;
    }

    public int numOfEdges() {
        int count = 0;
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if(adj[i][j] != 0)
                    count++;
            }
        }
        return count / 2;
    }

    public void neighbor(int vertice) {
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if(i == vertice) {
                for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                    if(adj[i][j] != 0)
                        System.out.print(j);
                }
            }
        }
        System.out.println();
    }

    public boolean checkExistEdge(int vertice1, int vertice2) {
        return adj[vertice1][vertice2] != 0;
    }

    public AL convertToAL() {
        AL al = new AL(NUMBER_OF_VERTICES);

        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            al.getAdj().add(new LinkedList <Integer >());
            for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if(adj[i][j] != 0)
                    al.getAdj().get(i).add(j);
            }
        }
        return al;
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Queue <Integer > queue = new LinkedList <Integer >();
        visited[s] = true;
        queue.offer(s);
        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x + " ");
        
            for(int i = 0; i < NUMBER_OF_VERTICES; i++){
                if(adj[x][i] != 0 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private void DFS_recur(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i = 0; i < NUMBER_OF_VERTICES; i++){
            if(adj[v][i] != 0 && visited[i] == false){
                DFS_recur(i, visited);
            }
        }
    }
        
    public void DFS(int v){
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(v, visited);
    }

    public void DFS_stack(int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        Stack <Integer > stack = new Stack<>();
        visited[v] = true;
        stack.push(v);
        while(!stack.isEmpty()) {
            int x = stack.pop();
            System.out.print(x + " ");
        
            for(int i = 0; i < NUMBER_OF_VERTICES; i++){
                if(adj[x][i] != 0 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public boolean isReachable(int u, int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        return isReachable(u, v, visited);
    }

    private boolean isReachable(int current, int target, boolean[] visited) {
        visited[current] = true;

        if (current == target) {
            return true;
        }

        for (int neighbor = 0; neighbor < NUMBER_OF_VERTICES; neighbor++) {
            if (adj[current][neighbor] != 0 && 
                !visited[neighbor] &&
                isReachable(neighbor, target, visited)) {
                    return true;
            }
        }

        return false;
    }

}