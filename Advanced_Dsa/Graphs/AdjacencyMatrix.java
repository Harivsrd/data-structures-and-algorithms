import java.util.Scanner;

class Graph {
    int n,m[][];
    Graph(int n) {
        this.n = n;
        m = new int[n][n];
    }

    public void addEdge(int u, int v){
        m[u][v] = 1;
        m[v][u] = 1;
    }
    public void display() {
        for(int r[] : m) {
            for(int x : r){
                System.out.print(x+" ");
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
            System.out.print("Enter u v :");
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x, y);
            System.out.print("Enter -1 to cancel insert (0) :");
            int e = sc.nextInt();
            if(e==-1)
                break;
        }
        g.display();
    }
}
