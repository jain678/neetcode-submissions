class Solution {
    private int solve(int i, int [] cost, int [] dp){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != 0) return dp[i];

        return dp[i] = cost[i] + Math.min(solve(i+1, cost, dp), solve(i+2, cost, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp1 = new int[n+1];
        int [] dp2 = new int[n+1];
        for(int i = 0; i < n; i++){
            System.out.print(dp1[i]);

        }
        return Math.min(solve(0, cost, dp1),solve(1, cost, dp2));
    }
}
