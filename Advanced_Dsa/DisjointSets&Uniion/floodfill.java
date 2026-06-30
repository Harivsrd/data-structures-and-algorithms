
import java.util.Scanner;

public class floodfill {
    private static int[][] flood(int img[][], int sr, int sc, int newCol){
        if(img[sr][sc] == newCol) return img;
        int m = img.length;
        int n = img[0].length;
        int oldC = img[sr][sc];
        dfs(img, sr, sc, m, n, oldC, newCol);
        return img;
    }
    private static void dfs(int[][] img, int sr, int sc, int m, int n, int oldC, int newC) {
        if(sr >= m || sc >= n || sr < 0 || sc <0 ){
            return ;
        }
        if(img[sr][sc] != oldC) return;
        img[sr][sc] = newC;

        dfs(img, sr+1, sc, m, n, oldC, newC);
        dfs(img, sr-1, sc, m, n, oldC, newC);
        dfs(img, sr, sc+1, m, n, oldC, newC);
        dfs(img, sr, sc-1, m, n, oldC, newC);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int img[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                img[i][j] = sc.nextInt();
            }
        }
        int sr = sc.nextInt();
        int se = sc.nextInt();
        int newC = sc.nextInt();
        int[][] res = flood(img, sr,se, newC);
        for(int[] r : res) {
            for(int x : r){
                System.out.print(x+" ");
            }
            System.out.println();
        }

    }
}
