import java.util.Scanner;
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;


public class EL {
    private Vector <IntegerTriple> edges;

    public EL(){
        edges = new Vector <IntegerTriple >();
    }

    public void addEdge(int w, int u, int v){
        edges.add(new IntegerTriple(w,u,v));
    }

    public void printGraph(){
        for(int i = 0; i < edges.size(); i++){
            System.out.println(edges.get(i));
        }
    }

    public void input(Scanner sc){
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] component = line.split(" ");
            addEdge(Integer.valueOf(component[0]), Integer.valueOf(component[1]), Integer.valueOf(component[2]));
        }
    }

    public int numOfVertices() {
        Set<Integer> ver = new HashSet<>();
        for(IntegerTriple i: edges) {
            ver.add(Integer.valueOf(i.getSource()));
            ver.add(Integer.valueOf(i.getDest()));
        }
        return ver.size();
    }

    public int numOfEdges() {
        return edges.size();
    }

    public void neighbor(int vertice) {
        for(IntegerTriple i: edges)
            if(i.getSource() == vertice)
                System.out.print(i.getDest());
        System.out.println();
    }

    public boolean checkExistEdge(int vertice1, int vertice2) {
        for(IntegerTriple i: edges)
            if((i.getSource() == vertice1 && i.getDest() == vertice2) ||
                (i.getSource() == vertice2 && i.getDest() == vertice1))
                    return true;
        return false;
    }
}
