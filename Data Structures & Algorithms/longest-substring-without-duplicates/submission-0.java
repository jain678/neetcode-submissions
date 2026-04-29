class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> st = new HashSet<>();
       int i = 0, j = 0;
       int ans = 0;
       while(j < s.length()){
        if(!st.contains(s.charAt(j))){
            st.add(s.charAt(j));
            j++;
        }
        else{
            st.remove(s.charAt(i));
            i++;
        }
        ans = Math.max(ans, j-i);
       }
       return ans;
    }
}
