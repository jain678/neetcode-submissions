class Solution {
    private String addString(String num1, String num2){
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        s1.reverse();
        s2.reverse();
        StringBuilder ans = new StringBuilder("");
        int n1 = s1.length(), n2 = s2.length();
        int i = 0, j = 0;
        int carry = 0;
        while(i< n1 && j < n2){
            int a = s1.charAt(i)-'0' , b = s2.charAt(j) - '0';
            int sum = (a+b+carry)%10;
            carry = (a+b+carry)/10;

            ans.append(sum +"");
            i++;
            j++;
        }
        while( i < n1){
            int a = s1.charAt(i) - '0';
            i++;
            ans.append((a + carry)%10 +"");
            carry = (a+carry)/10;
        }
        while(j < n2){
            int a = s2.charAt(j) - '0';
            j++;
            ans.append((a + carry)%10 +"");
            carry = (a+carry)/10;
        }
        if(carry!=0)
        ans.append(carry + "");
        ans.reverse();
        System.out.println(ans);
        return ans.toString();

    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") ) return "0";
        if(num2.equals("0")) return "0";
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        s1.reverse();
        s2.reverse();
        int mul = 0;
        String ans = "";
        for(int i = 0 ; i< s1.length(); i++){
            int carry = 0;
            StringBuilder s = new StringBuilder("");
            for(int j = 0 ; j< s2.length(); j++){
                int a = s1.charAt(i) - '0', b = s2.charAt(j) - '0';
                mul = (a*b + carry)%10;
                carry = (a*b + carry)/10;
                s.append(mul + "");
            }
            if(carry != 0){
                s.append(carry + "");
            }
            s.reverse();
            for(int j = 0; j< i; j++){
                s.append(0+"");
            }
            if(i == 0){
                ans += s;
            }
            else{
                ans = addString(ans, s.toString());
            }
        }
        return ans;
    }
}
