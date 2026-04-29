class Solution {
public:
    void solve(vector<int> &nums, vector<int> res, vector<vector<int>> & ans, int i){
        if(i == nums.size()){
            ans.push_back(res);
            return;
        }
        res.push_back(nums[i]);
        solve(nums,res, ans, i+1);
        res.pop_back();
        while(i+1 < nums.size() && nums[i] == nums[i+1]){
            i++;
        }
        solve(nums,res,ans, i+1);
        return;
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> res;
        sort(nums.begin(), nums.end());
        solve(nums, res, ans, 0);
        return ans;
    }
};
