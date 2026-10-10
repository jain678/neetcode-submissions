class Solution {
public:
    int maxArea(vector<int>& heights) {
        int i = 0, j = heights.size() -1 ;
        int ans = 0;
        while(i < j){
            int area = (j-i)*(min(heights[j], heights[i]));

            ans = max(ans, area);
            if(heights[i] < heights[j])
            i++;
            else
            j--;
        }
        return ans;

    }
};
