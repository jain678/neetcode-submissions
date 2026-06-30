class Solution {
    private int solve(int n, int [] nums ,int target, int [] dp){
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(dp[target] != -1) return dp[target];
        int ways = 0;
        for(int num : nums){
            ways += solve( n, nums, target - num, dp);
        }

        return dp[target] = ways;
    }
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target+1];
        int n = nums.length;
        Arrays.fill(dp, -1);
        return solve( n, nums, target, dp);
    }
}