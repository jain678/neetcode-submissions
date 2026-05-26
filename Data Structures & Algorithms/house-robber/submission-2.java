class Solution {
    private int solve(int i,int n, int [] nums, int [] dp){
        if(i>=n) return 0;
        if(dp[i] != 0){
            return dp[i];
        }
        return dp[i] =  Math.max(solve(i+1, n, nums, dp), solve(i+2, n, nums, dp) + nums[i]);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n+1];
        return solve(0,n, nums, dp);
    }
}
