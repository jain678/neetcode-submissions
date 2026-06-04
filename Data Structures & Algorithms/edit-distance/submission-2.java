class Solution {
    private int solve(String s1, String s2, int n, int m, int [][] dp){
        if(s1.equals(s2)){
            return 0;
        }
        if(n == 0) return m;
        if(m == 0) return n;
        if(dp[n][m] != 0) return dp[n][m];
        int operation = 0;
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            operation = solve(s1,s2,n-1,m-1, dp);
        }
        else {
            operation = 1+Math.min(solve(s1,s2,n-1,m-1, dp), Math.min(solve(s1,s2,n-1,m, dp), solve(s1,s2,n,m-1, dp)));
        }
        return dp[n][m] = operation;
    }
    public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int [][] dp = new int [n+1][m+1];
        return solve(s1, s2, n, m, dp);
    }
}
