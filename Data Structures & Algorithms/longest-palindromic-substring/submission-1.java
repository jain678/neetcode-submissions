class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i<len; i++){
            StringBuilder s1 = new StringBuilder ("");
            s1.append(s.charAt(i));
            int j = i-1, k = i+1;
            if(ans.length() < s1.length()){
                ans = s1;
            }
            while(j>=0 && k<len){
                if(s.charAt(j) == s.charAt(k)){
                    StringBuilder temp = new StringBuilder("");
                    temp.append(s.charAt(j));
                    temp.append(s1);
                    temp.append(s.charAt(k));
                    if(ans.length() < temp.length()){
                        ans = temp;
                        System.out.println(ans);
                    }
                    s1 = temp;
                    j--; 
                    k++;
                }
                else{
                    break;
                }
            }
        }
        
        for(int i = 0; i< len-1; i++){
            StringBuilder s1 = new StringBuilder ("");
            if(s.charAt(i)==s.charAt(i+1)){
                s1.append(""+s.charAt(i)+s.charAt(i+1));
            }
            int j = i-1, k = i+2;
            if(ans.length() < s1.length()) {
                ans = s1;
            }
            while(j>=0 && k<len){
                if(s.charAt(j) == s.charAt(k)){
                    StringBuilder temp = new StringBuilder("");
                    temp.append(s.charAt(j));
                    temp.append(s1);
                    temp.append(s.charAt(k));
                    if(ans.length() < temp.length()){
                        ans = temp;
                    }
                    s1 = temp;
                    j--; 
                    k++;
                }
                else{
                    break;
                }
            }
        }
        return ans.toString();
    }
}
