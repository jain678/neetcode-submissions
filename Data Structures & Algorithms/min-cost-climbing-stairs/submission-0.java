class Solution {
    private int solve(int i, int n, int [] cost, int [] dp){
        if(i >= n){
            return 0;
        }

        if(dp[i] != 0){
            return dp[i];
        }
        return dp[i] = cost[i] + Math.min(solve(i+1, n, cost, dp), solve(i+2, n, cost, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n+1];
        return Math.min(solve(0, n, cost, dp), solve(1, n, cost, dp));
    }
}
