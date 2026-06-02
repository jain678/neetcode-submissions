class Solution {
    private boolean solve(int i, int n, int sum, int currSum, int [] nums, Boolean [][] dp){
        if(currSum == sum) return true;
        if(i == n) return false;
        if(dp[i][currSum] != null) return dp[i][currSum];
        return dp[i][currSum] =  solve(i+1, n, sum, currSum, nums, dp) ||
        solve(i+1, n, sum, currSum + nums[i], nums, dp);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 == 1) return false;
        Boolean [][] dp = new Boolean[nums.length][sum];
        return solve(0, nums.length, sum/2, 0, nums, dp);
    }
}
