class Solution {
    private int solve(int [] coins, int amount, int n, int [][] dp){
        if(amount == 0) return 1;
        if(n == 0) return 0;
        if(dp[n-1][amount-1] != -1) return dp[n-1][amount-1];

        int ways = 0;
        ways += solve(coins, amount, n-1, dp);
        if(amount >= coins[n-1])
        ways +=  solve(coins, amount - coins[n-1], n, dp);
        return dp[n-1][amount-1] = ways;
    }
    public int change(int amount, int[] coins) {
       int n = coins.length;
       int [][] dp = new int [n+1][amount+1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(coins, amount, n, dp);
    }
}
