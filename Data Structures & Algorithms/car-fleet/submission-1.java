class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = target - position[i];
            cars[i][1] = speed[i];
        }
        
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> st = new Stack<>();
        for(int i = 0 ; i< speed.length; i++){
            double time = (double)(cars[i][0]) / cars[i][1];
            while(!st.empty() && st.peek() <= time){
                st.pop();
            }
            st.push(time);
            // System.out.println(time);
        }
        System.out.println(st.peek());
        return st.size();
    }
}
