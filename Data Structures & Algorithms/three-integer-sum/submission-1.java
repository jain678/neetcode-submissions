class Solution {
    private List<List<Integer>> twoSum(int [] nums, int i, int j, int sum){
        List<List<Integer>> ans = new ArrayList<>();
        while(i < j){
            if(nums[i] + nums[j] == sum){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
                i++;
                j--;
            }
            else if(nums[i] + nums[j] < sum){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lt = new ArrayList<>();
        for(int i = 0; i< nums.length-2; i++){
            int sum = 0 - nums[i];
                List<List<Integer>> res = twoSum(nums, i+1, nums.length-1, sum);
                if(res.size()!= 0){
                    for(List<Integer> l: res){
                        l.add(nums[i]);
                        lt.add(l);
                    }
            }
        }  
        Set<List<Integer>> st = new HashSet<>();
        for(List<Integer> l : lt){
            st.add(l);
        } 
        lt.clear();
        for(List<Integer> l : st){
            lt.add(l);
        }
        return lt;
    }
}
