class Solution {
public:
    void solve(vector<int> nums, vector<int> res, vector<vector<int>> & ans, int i){
        if(i == nums.size()) return;
        solve(nums, res, ans, i+1);
        res.push_back(nums[i]);
        solve(nums, res, ans, i+1);
        ans.push_back(res);
        return;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> res;
        ans.push_back(res);
        solve(nums, res, ans, 0);
        return ans;
    }
};
