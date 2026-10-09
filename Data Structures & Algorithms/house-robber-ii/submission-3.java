class Solution {
    private int solve(int i, int n, int [] nums, int [] dp){
        if(i > n) return 0;
        if(dp[i] != 0) return dp[i];
        return dp[i] = Math.max(solve(i+1, n, nums, dp), nums[i] + solve(i+2, n, nums, dp));
    }
    public int rob(int[] nums) {

        int n = nums.length;
        if(n == 1) return nums[0];
        int [] dp1= new int[n];
        int [] dp2 = new int[n];
        return Math.max(solve(0, n-2, nums, dp1), solve(1, n-1, nums, dp2));

    }
}
