class Solution {
    private int solve(int i, int n, int [] coins, int amount, int [][] dp){
        if(amount == 0){
            return 0;
        }
        if(i >= n || amount < 0){
            return (int)1e9;
        }
        
        if(dp[i][amount] != (int)1e9){
            return dp[i][amount];
        }
        return dp[i][amount] = Math.min(1+solve(i, n, coins, amount - coins[i], dp), solve(i+1, n, coins, amount, dp));

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];
        for(int i = 0 ; i<=n; i++){
            for(int j = 0; j<= amount; j++){
                dp[i][j] = (int)1e9;
            }
        }

        int ans = solve(0, n, coins, amount, dp);
        return ans == 1e9 ? -1 : ans;
    }
}
