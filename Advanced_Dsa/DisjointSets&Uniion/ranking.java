import java.util.*;

public class DSU {
    int n;
    int parent[];
    int rank[];

    DSU(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0; 
        }
    }

    int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); 
        }
        return parent[i];
    }

    void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);

        if (root1 == root2) return; 

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++; 
        }
    }

    boolean isFriends(int i, int j) {
        return find(i) == find(j);
    }

    int findGroups() {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(find(i));
        }
        return hs.size();
    }

    void printGroups() {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i);
            hm.putIfAbsent(p, new ArrayList<>());
            hm.get(p).add(i);
        }
        for (int k : hm.keySet()) {
            System.out.println("Group leader " + k + " -> " + hm.get(k));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DSU obj = new DSU(n);

        while (true) {
            System.out.println("-----Menu------");
            System.out.println("1. Add friendship ");
            System.out.println("2. Execute query friend or not");
            System.out.println("3. How many friendship groups are there");
            System.out.println("4. Persons in each relation");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            if (choice == 1) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                obj.union(i, j);
            } else if (choice == 2) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                System.out.println(obj.isFriends(i, j) ? i + " and " + j + " are friends" : i + " and " + j + " are not friends");
            } else if (choice == 3) {
                System.out.println(obj.findGroups());
            } else if (choice == 4) {
                obj.printGroups();
            } else if (choice == 5) {
                break;
            }
        }
    }
}
