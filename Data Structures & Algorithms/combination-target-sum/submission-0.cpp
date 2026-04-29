class Solution {
public:
    void solve(vector<int> nums, vector<int> res, vector<vector<int>> & ans, int target, int i){
        if(target == 0){
            ans.push_back(res);
            return;
        }
        if(i == nums.size()) return;
        if(target < 0) return;

        solve(nums, res, ans, target, i+1);
        res.push_back(nums[i]);
        solve(nums,res, ans, target - nums[i], i);

        return;
    }
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<vector<int>> ans;
        vector<int> res;
        solve(nums, res, ans, target, 0);
        return ans;
    }
};
