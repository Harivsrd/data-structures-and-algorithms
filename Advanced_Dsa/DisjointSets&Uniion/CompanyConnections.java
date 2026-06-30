import java.util.*;

class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY; 
        }
    }
}

public class CompanyConnections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int q = sc.nextInt(); 

        DSU dsu = new DSU(n);

        for (int i = 0; i < q; i++) {
            String type = sc.next();
            if (type.equals("1")) { 
                int x = sc.nextInt();
                int y = sc.nextInt();
                dsu.union(x, y);
            } else if (type.equals("2")) {
                int x = sc.nextInt();
                System.out.println("Employee " + x + " belongs to company " + dsu.find(x));
            }
            else if(type.equals)
        }
    }
}
