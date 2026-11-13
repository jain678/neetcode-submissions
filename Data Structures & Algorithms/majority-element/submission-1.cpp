class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int cand = nums[0];
        int size = 1;
        for(int i = 1; i< n; i++){
            if(size == 0){
                cand = nums[i];
            }
            size+= (nums[i] == cand) ? 1: -1;
        }
        return cand;
    }
};