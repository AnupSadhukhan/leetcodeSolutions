class Solution {
    public String minRemoveToMakeValid(String s) {
        /* Approch 1 */
        /*
        StringBuilder sb=new StringBuilder();
        int open=0;
        int close=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
                sb.append(c);
            }
            else if(c==')' && open>close){
                sb.append(c);
                close++;
            }
            else if(c!='(' && c!=')'){
                sb.append(c);
            }
        }
        char[] arr=sb.toString().toCharArray();
        sb=new StringBuilder();
        open=0;
        close=0;
        for(int i=arr.length-1;i>=0;i--){
            char c=arr[i];
             if(c=='(' && open<close){
                open++;
                sb.insert(0,c);
            }
            else if(c==')'){
                sb.insert(0,c);
                close++;
            }
            else if(c!='(' && c!=')'){
