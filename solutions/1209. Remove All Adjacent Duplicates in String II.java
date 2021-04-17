class Solution {
    // 3ms
    // take a count array or pointer which will keep the count of adjacent chars, if adjucent char count become k,
    // we will remove last k chars( for stack last node) and reduce index or i by k.
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/discuss/392933/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
    public String removeDuplicates(String s, int k) {
        int i=0;
        char[] chs=s.toCharArray();
        int[] count=new int[chs.length];
        for(int j=0;j<chs.length;j++,i++){
            chs[i]=chs[j];
            count[i]=1+((i>0 && chs[i]==chs[i-1])?count[i-1]:0);
            if(count[i]==k){
                i-=k;
            }
        }
        return new String(chs,0,i);
        
    }
    /* //13ms
       class Node{
        char c;
        int count;
        Node(char c,int count){
            this.c=c;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack=new Stack<>();
        stack.push(new Node(s.charAt(0),1));
        char[] arr=s.toCharArray();
        
        for(int i=1;i<arr.length;i++){
                if(!stack.isEmpty() && stack.peek().c == arr[i]){
                    stack.peek().count++;
                }else{
                    //not repeat
                    stack.push(new Node(arr[i],1));
                }
                //remove when num of dup == k
                if(stack.peek().count==k) stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.empty()){
            Node n=stack.pop();
            for(int i=0;i<n.count;i++){
                sb.insert(0,n.c);
            }
        }
        return sb.toString();
    }
    */
    
}
