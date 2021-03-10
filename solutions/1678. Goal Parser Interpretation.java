class Solution {
    public String interpret(String command) {
       
        StringBuilder sb=new StringBuilder();
        char[] arr=command.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='G'){
                sb.append("G");
            }
            if(arr[i]==')'){
                if(i>0 && arr[i-1]=='('){
                    sb.append("o");
                }
                else{
                    sb.append("al");
                }
            }
        }
        return sb.toString();
        
        
    }
}
