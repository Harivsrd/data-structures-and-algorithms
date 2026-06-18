class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] rowPrefix = new int[n][m];
        int[][] colPrefix = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            rowPrefix[i][0] = mat[i][0];
            for(int j = 1; j < m; j++){
                rowPrefix[i][j] = rowPrefix[i][j-1] + mat[i][j];
            }
        }
        for(int j=0; j<m; j++){
            colPrefix[0][j] = mat[0][j];
            for(int i = 1; i <n; i++){
                colPrefix[i][j] = colPrefix[i-1][j] + mat[i][j];
            }
        }
        
        int coverage = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0) {
                    
                    if (j > 0 && rowPrefix[i][j-1] > 0) coverage++;
                    if (j < m-1 && (rowPrefix[i][m-1] - rowPrefix[i][j])>0) coverage++;
                    if (i > 0 && colPrefix[i-1][j] > 0) coverage++;
                    if (i < n-1 && (colPrefix[n-1][j] - colPrefix[i][j]) > 0) coverage++;
                    
                }
            }
        }
        return coverage;
    }
}