class Solution {
public:
    int solve(vector<int>& coins, int i,int n, int amt, vector<vector<int>> & dp){
        if(amt == 0) return 0;
        if(i>=n || amt < 0) return (int)1e9;

        if(dp[i][amt] != (int)1e9) return dp[i][amt];
        return dp[i][amt] = min(solve(coins, i+1, n, amt, dp), 1+solve(coins, i, n, amt - coins[i], dp));
    }
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        if(amount == 0) return 0;
        int gcd = 0;
        for(int i = 0; i< n; i++){
            gcd = __gcd(gcd, coins[i]);
        }
        if(amount % gcd != 0) return -1;
        vector<vector<int>> dp(n+1, vector<int>(amount+1, 1e9));
        int ans = solve(coins, 0,n, amount, dp);
        return ans == (int)1e9 ? -1: ans;
    }
};
