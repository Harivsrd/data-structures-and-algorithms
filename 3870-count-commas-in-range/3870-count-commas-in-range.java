class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;
        else if(n < 1000000) return (n - 1000)+1;
        return 1;
    }
}