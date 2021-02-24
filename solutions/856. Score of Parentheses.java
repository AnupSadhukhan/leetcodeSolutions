class Solution {
    static int idx=0;
    public int scoreOfParentheses(String S) {
        /*Stack<String> stack=new Stack<String>();
        char[] c=S.toCharArray();
        for(int i=0;i<c.length;i++){
            if(stack.empty()){
                stack.push(c[i]+"");
            }
            else{
                if(c[i]=='('){
                    stack.push("(");
                }
                else{
                    String value=stack.pop();
                    if(value.equals("(")){
                        
                        stack.push("1");
                    }
                    else{
                        int score=Integer.parseInt(value);
                        while(!stack.peek().equals("(")){
                            score+=Integer.parseInt(stack.pop());
                        }
                         stack.pop();
                        stack.push((2*score)+"");
                    }
                    
                }
            }
        }
        int score=0;
        while(!stack.empty()){
            score+=Integer.parseInt(stack.pop());
        }
        return score;
        */
        /* approch 2 */
        int bal=0,ans=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(') bal++;
            else{
                bal--;
                if(S.charAt(i-1)=='('){
                    ans+=1<<bal;
                }
            }
        }
        return ans;
    }
   
}
