class Solution {
    private int solve(String s, int j, int k, int len, StringBuilder st){
        StringBuilder res = new StringBuilder(st);
        int cnt = 0;
        while(j>=0 && k < len){
            if(s.charAt(j) == (s.charAt(k))){
                StringBuilder temp = new StringBuilder("");
                temp.append(s.charAt(j));
                temp.append(st);
                temp.append(s.charAt(k));
                st = temp;
                cnt++;
                j--;
                k++;
            }
            else{
                break;
            }
        }
        return cnt;
    }
    public int countSubstrings(String s) {
        int len = s.length();
        System.out.println(len);
        int cnt = 0;
        StringBuilder ans = new StringBuilder("");
        for(int i = 0 ; i < len ;i++){
            StringBuilder s1 = new StringBuilder("" + s.charAt(i));
            cnt  += solve(s, i-1, i+1, len, s1);
            
        }
        for(int i = 0; i< len-1; i++){
            StringBuilder s1 = new StringBuilder("");
            if(s.charAt(i) == (s.charAt(i+1))){
                s1.append(""+s.charAt(i)+s.charAt(i));
                cnt++;
                cnt += solve(s, i-1, i+2, len, s1);
            }
            

        }
        return cnt+len;
    }
}
