class Solution {
    private int solve(String s1, String s2, int m, int n, int [][] dp){
        if(m == 0 || n == 0) return 0;
        if(dp[m-1][n-1] != 0){
            return dp[m-1][n-1];
        }
        int ans = 0;
        if(s1.charAt(m-1) == (s2.charAt(n-1))){
            ans = 1 + solve(s1, s2, m-1, n-1, dp);
        }
        else {
            ans = Math.max(solve(s1, s2, m-1, n, dp), solve(s1, s2, m, n-1, dp));
        }
        return dp[m-1][n-1] = ans;
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int [][] dp = new int [m][n];
        for(int i= 0; i< m; i++){
            for(int j = 0 ;j< n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{break;}
            }
        }
        return solve(s1, s2, m, n, dp);
    }
}
