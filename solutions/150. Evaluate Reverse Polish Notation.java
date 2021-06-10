class Solution {
    // use stack to evalute RPN, if we see any operator pop out last two 
    // operand and perform operation and push the result, else push the operand
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        Stack<String> stack=new Stack<>();
        int value=0;
        for(String token : tokens){
            if(token.equals("+")){
                int operand1=Integer.parseInt(stack.pop());
                int operand2=Integer.parseInt(stack.pop());
                value=(operand2+operand1);
                stack.push(value+"");
            }
            else if(token.equals("-")){
                int operand1=Integer.parseInt(stack.pop());
                int operand2=Integer.parseInt(stack.pop());
                value=(operand2-operand1);
                stack.push(value+"");
            }
            else if(token.equals("*")){
                int operand1=Integer.parseInt(stack.pop());
                int operand2=Integer.parseInt(stack.pop());
                value=(operand2*operand1);
                stack.push(value+"");
            }
            else if(token.equals("/")){
                int operand1=Integer.parseInt(stack.pop());
                int operand2=Integer.parseInt(stack.pop());
                value=(operand2/operand1);
                stack.push(value+"");
                
            }
            else
                stack.push(token);
            
        }
        return value;
    }
}
