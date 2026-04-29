class Solution {
public:
void solve(vector<int> nums, vector<int> res, vector<vector<int>> & ans, int target, int i){
        if(target == 0){
            ans.push_back(res);
            return;
        }
        if(i == nums.size()) return;
        if(target < 0) return;
        res.push_back(nums[i]);
        solve(nums, res, ans, target - nums[i], i+1);
        res.pop_back();
       
        while(i+1 < nums.size() && nums[i] == nums[i+1]){
            i++;
        }
         solve(nums,res, ans, target, i+1);

        return;
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> res;
        sort(candidates.begin(), candidates.end());
        solve(candidates, res, ans, target, 0);
        vector<vector<int>> t;
        for(auto i : ans)
        t.push_back(i);
        return t;
    }
};
