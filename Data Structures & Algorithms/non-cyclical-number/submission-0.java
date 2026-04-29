class Solution {
    private Integer sumOfSquare (int n){
        int sum = 0;
        while(n != 0){
            int x = n%10;
            n = n/10;
            sum += (x * x);
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow  = n , fast = sumOfSquare(n);
        while(slow != fast){
            fast = sumOfSquare(fast);
            fast = sumOfSquare(fast);
            slow = sumOfSquare(slow);
        }
        return fast == 1;
    }
}
