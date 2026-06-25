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

    public boolean dfs(){
        boolean vis[] = new boolean[n];
        dfs1(vis,0);
        for(boolean v : vis){
            if(v==false){
                return false;
            }
        }
        return true;
    }

    public void dfs1(boolean vis[], int s) {
        vis[s] = true;
        for(int i = 0; i < n; i++) {
            if(!vis[i] && m[s][i]==1){
                dfs1(vis,i);
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
        boolean res = g.dfs();
        System.out.println(res==true ? "Connected" : "Disconnected");
    }
}