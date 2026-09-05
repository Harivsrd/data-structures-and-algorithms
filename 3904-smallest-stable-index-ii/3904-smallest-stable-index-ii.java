class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int minEle[] = new int[n];
        minEle[n-1] = nums[n-1];
        for(int i = n - 2; i >=0 ; i--) {
            minEle[i] = Math.min(minEle[i+1], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int val = max - minEle[i];
            if(val <= k) return i;
        }
        return -1;
    }
}