import java.util.*;

class Graph {
    int n;
    List<List<Integer>> adj;

    Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for(int i=0; i < n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        if (u >= 0 && u < n && v >= 0 && v < n) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public void display() {
        for(int i = 0; i < n; i++) {
            System.out.print(i + "->");
            for(int v : adj.get(i)){
                System.out.print(v+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of vertices :");
        int n = sc.nextInt();
        Graph g = new Graph(n);
        while(true) {
            System.out.print("Enter u v or -1 to stop:");
            int x = sc.nextInt();
            if (x==-1) 
                break;
            int y = sc.nextInt();
            g.addEdge(x, y);
        }
        g.display();

    }
        
}
