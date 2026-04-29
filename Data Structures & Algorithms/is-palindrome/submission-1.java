class Solution {
    public boolean isPalindrome(String s) {
        // s.toLowerCase();
        String [] strArray = s.split("[^a-zA-Z0-9]+");
        String result = String.join("", strArray);
        StringBuilder sb = new StringBuilder(result);
        String str = sb.toString().toLowerCase();
        int i = 0, j = str.length() -1;
        System.out.println(str);
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
