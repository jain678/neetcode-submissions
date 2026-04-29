class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] left = new int [n];
        int [] right = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i< n; i++){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.empty())
            left[i] = -1;
            else
            left[i] = st.peek();
            st.push(i);

            
        }

        st.clear();
        for(int i = n-1; i>=0; i--){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.empty())
            right[i] = n;
            else
            right[i] = st.peek();
            st.push(i);
        }
        int area = 0, mx = 0;
        for(int i = 0 ; i< n; i++){
            int width = right[i] - left[i] -1;
            area = Math.max(area, width * heights[i]);
        }
        return area;

    }
}
