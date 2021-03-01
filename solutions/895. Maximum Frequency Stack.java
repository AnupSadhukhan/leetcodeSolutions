class FreqStack {
    int max_freq=0;
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> stack_freq;
    public FreqStack() {
        max_freq=0;
        freq=new HashMap<Integer,Integer>();
        stack_freq=new HashMap<Integer,Stack<Integer>>();
    }
    
    public void push(int x) {
       
        Integer cur_freq=freq.get(x);
        if(cur_freq==null) cur_freq=1;
        else cur_freq+=1;
        freq.put(x,cur_freq);
        if(cur_freq>max_freq) max_freq=cur_freq;
        Stack<Integer> st=stack_freq.get(cur_freq);
        if(st==null){
            st=new Stack<Integer>();
        }
        st.push(x);
        stack_freq.put(cur_freq,st);
    }
    
    public int pop() {
        int elm=stack_freq.get(max_freq).pop();
        if(stack_freq.get(max_freq).empty()){
            max_freq--;
        }
        int cur_freq=freq.get(elm);
        if(cur_freq==1) freq.remove(elm);
        else freq.put(elm,cur_freq-1);
        return elm;
    }
}
​
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
