class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        vector<int> leftSmall(n,-1), rightSmall(n,0);
        stack<int> st;
        for(int i = 0 ;i< n; i++){
            while(!st.empty() && heights[st.top()] >= heights[i]){
                st.pop();
            }
            if(st.empty() == false){
                leftSmall[i] = st.top();
            }
            else{
                leftSmall[i] = -1;
            }
            st.push(i);
        }
        stack<int> st1;
        for(int i = n-1; i>=0; i--){
            while(!st1.empty() && heights[st1.top()] >= heights[i]){
                st1.pop();
            }
            if(!st1.empty()){
                rightSmall[i] = st1.top();
            }
            else{
                rightSmall[i] = n;
            }
            st1.push(i);
        }
        int ans = 0;
        for(int i = 0; i< n; i++){
            // cout<<rightSmall[i]<<" "<<leftSmall[i]<<endl;
            ans = max(ans,(rightSmall[i] - leftSmall[i] - 1)*heights[i]);
        }
        return ans;
    }
};
