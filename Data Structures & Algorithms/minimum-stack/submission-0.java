class MinStack {
    long min;
    Stack<Long> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.empty()){
            st.push(0L);
            min = val;
        }
        else {
            st.push((long)val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(st.empty()) return;

        long pop = st.pop();
        if(pop < 0){
            min = min - pop;
        }
    }
    
    public int top() {
        long top = st.peek();
        if(top >= 0){
            return (int)(top + min);
        }
        else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
