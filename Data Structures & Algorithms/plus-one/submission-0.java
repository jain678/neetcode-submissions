class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> lt = new ArrayList<>();
        int carry = 0;
        for(int i = n-1; i>=0; i--){
            int num = digits[i];
            if(i == n-1){
                num++;
            }
            int x = (num+carry)%10;
            carry = (num+carry)/10;
            lt.add(x);
        }
        if(carry != 0) lt.add(carry);

        Collections.reverse(lt);
        return lt.stream().mapToInt(i->i).toArray();
    }
}
