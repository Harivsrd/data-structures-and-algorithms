class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int pref = n;
        int f[] = new int[2*n+1];
        f[n] = 1;
        long ans = 0;
        long less = 0;
        for(int num : nums) {
            if(num == target) {
                less += f[pref];
                pref++;
            }
            else{
                pref--;
                less -= f[pref];
            }
            f[pref]++;
            ans+=less;
        }
        return ans;
    }
}