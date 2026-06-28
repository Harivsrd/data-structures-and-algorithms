// Recursion Approach
class Solution {
    final static int MOD = 1000000007;
    public int countStrings(int n, int k) {
        // code here
        return (solve(1,0,0,n,k) + solve(1,0,1,n,k))%MOD;
    }
    private static int solve(int pos, int adjCount, int lastBit, int n,int k) {
        if(pos == n) {
            if(adjCount == k) {
                return 1;
            }
            else{
                return 0;
            }
        }
        long ans = 0;
        ans += solve(pos+1, adjCount, 0, n, k);
        if(lastBit == 1) {
            ans += solve(pos+1, adjCount+1, 1,n,k);
        }
        else{
            ans += solve(pos+1, adjCount, 1, n,k);
        }
        return (int)(ans%MOD);
    }
}

// Dynamic Programming - Memorization 
class Solution {
    final static int MOD = 1000000007;
    static int[][][] dp;
    public int countStrings(int n, int k) {
        // code here
        dp = new int[n+1][k+1][2];
        for(int[][] arr : dp) {
            for(int row[] : arr){
                Arrays.fill(row, -1);
            }
        }
        return (solve(1,0,0,n,k) + solve(1,0,1,n,k))%MOD;
    }
    private static int solve(int pos, int adjCount, int lastBit, int n,int k) {
        if(adjCount > k) return 0;
        if(pos == n) {
            if(adjCount == k) {
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[pos][adjCount][lastBit] != -1) {
            return dp[pos][adjCount][lastBit];
        }
        
        long ans = 0;
        ans += solve(pos+1, adjCount, 0, n, k);
        if(lastBit == 1) {
            ans += solve(pos+1, adjCount+1, 1,n,k);
        }
        else{
            ans += solve(pos+1, adjCount, 1, n,k);
        }
        return dp[pos][adjCount][lastBit] = (int)(ans%MOD);
    }
}


// DP - Tabulation 
class Solution {
    final static int MOD = 1000000007;
    public int countStrings(int n, int k) {
        // code here
        int dp[][][] = new int[n+1][k+1][2];
        
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= k ; j++) {
    
                dp[i][j][0] = (int)(((long)dp[i-1][j][0] + dp[i-1][j][1]) % MOD);
                dp[i][j][1] = dp[i-1][j][0];
                if(j > 0) {
                    dp[i][j][1] = (int)(((long)dp[i][j][1] + dp[i-1][j-1][1]) % MOD);
                }
            }
        }
        return (int)(((long)dp[n][k][0] + dp[n][k][1]) % MOD);
    }
}