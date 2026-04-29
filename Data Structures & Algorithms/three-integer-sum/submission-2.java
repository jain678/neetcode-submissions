class Solution {
    // private List<List<Integer>> twoSum(int [] nums, int i, int j, int sum){
    //     List<List<Integer>> ans = new ArrayList<>();
    //     while(i < j){
    //         if(nums[i] + nums[j] == sum){
    //             List<Integer> temp = new ArrayList<>();
    //             temp.add(nums[i]);
    //             temp.add(nums[j]);
    //             ans.add(temp);
    //             i++;
    //             j--;
    //             while(i < j && nums[i] == nums[i-1]) i++;
    //             while(i < j && nums[j] == nums[j+1]) j--;
    //         }
    //         else if(nums[i] + nums[j] < sum){
    //             i++;
    //         }
    //         else{
    //             j--;
    //         }
    //     }
    //     return ans;
    // }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lt = new ArrayList<>();
        for(int i = 0; i< nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;

            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    lt.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }

                else if(sum < 0)
                left++;
                else 
                right--;
            }
        }  
        
        return lt;
    }
}
