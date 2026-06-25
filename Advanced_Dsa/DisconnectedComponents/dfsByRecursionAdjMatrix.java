import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> dfs(){
        boolean vis[] = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs1(vis,i,res);
            }
        }
        return res;
    }

    public void dfs1(boolean vis[], int s, List<Integer> res) {
        vis[s] = true;
        res.add(s);
        for(int i = 0; i < n; i++) {
            if(!vis[i] && m[s][i]==1){
                dfs1(vis,i,res);
            }
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
        List<Integer> res = g.dfs();
        System.out.println(res);
    }
}
