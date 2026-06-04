class Solution {
    private int solve(int i, int n, int sum, int target, int [] nums, int [][] dp, int offset){
        if(i == n && sum == target) return 1;
        if(i == n) return 0;
        if(dp[i][sum+offset] != 0) return dp[i][sum+offset];
        int ways = solve(i+1, n, sum - nums[i], target, nums, dp, offset) + solve(i+1, n, sum + nums[i], target, nums, dp, offset);
        return dp[i][sum+offset] = ways;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int i : nums){
            total +=i;
        }
        int [][] dp= new int [n+1][2*total+1];
        return solve(0, n, 0, target, nums, dp, total);
    }
}
