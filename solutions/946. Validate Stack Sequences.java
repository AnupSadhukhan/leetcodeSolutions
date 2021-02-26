class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<Integer>();
        int j=0,i=0;
        for(i=0,j=0;i<pushed.length;){
            if(!stack.empty() && stack.peek()==popped[j]){
                //System.out.println("popped "+popped[j]);
                stack.pop();
                j++;
            }
            else{
                //System.out.println("pushed "+pushed[i]);
                stack.push(pushed[i++]);
            }
        }
        while(!stack.empty() && j<popped.length && stack.peek()==popped[j]){
            stack.pop();
            j++;
        }
        return stack.empty();
    }
}
