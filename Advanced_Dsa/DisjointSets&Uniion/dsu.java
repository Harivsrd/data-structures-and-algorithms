import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class dsu {
    int n;
    int parent[];
    dsu(int n){
        this.n = n;
        this.parent = new int[n];
        for(int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }
    int find(int i) {
        if(parent[i] == i) 
            return i;
        return find(parent[i]);
    }
    boolean isFriends(int i, int j) {
        int l1 = find(i);
        int l2 = find(j);
        return l1==l2;
    }
    void union(int i, int j) {
        int l1 = find(i);
        int l2 = find(j);
        if(l1 != l2) {
            parent[l1] = l2;
        }
    }
    int findGroups(){
        HashSet<Integer> hs = new HashSet<>();
        for(int x : parent) {
            hs.add(find(x));
        }
        return hs.size();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dsu obj = new dsu(n);
        
        while(true) {
            System.out.println("-----Menu------");
            System.out.println("1. Add friendship ");
            System.out.println("2.Execute query  friend or not:");
            System.out.println("3. How many friendship groups are there ");
            System.out.println("4. Persons in each relation ");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            if (choice == 1) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                obj.union(i,j);
            }
            else if (choice == 2) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                if(obj.isFriends(i,j)) {
                    System.out.println(i+" "+j+" are friends ");
                }
                else{
                    System.out.println(i+" "+j+" are not friends ");
                }
            }
            else if(choice == 3){
                int res = obj.findGroups();
                System.out.println(res);
            }
            else if(choice == 4) {
                HashMap<Integer, Integer> hm = new HashMap<>();
                for(int i = 0; i < n; i++ ){
                    int p = obj.find(i);
                    hm.put(p, hm.getOrDefault(p,0)+1);
                }
                for(int k : hm.keySet()) {
                    System.out.println(k + " -> "+hm.get(k));
                }
            }
            else if(choice==5) {
                break;
            }
            else{
                break;
            }
        }
    }
}
