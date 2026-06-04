class Solution {
    private int solve(int i, int n, int sum, int target, int [] nums){
        if(i == n && sum == target) return 1;
        if(i == n) return 0;
        int ways = solve(i+1, n, sum - nums[i], target, nums) + solve(i+1, n, sum + nums[i], target, nums);
        return ways;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(0, n, 0, target, nums);
    }
}
