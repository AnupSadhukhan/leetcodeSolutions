/*class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        Set<String> set_pass=new HashSet<>();
        Set<String> set_fail=new HashSet<>();
       
        for(String word : words){
            if(set_fail.contains(word)) continue;
            if(set_pass.contains(word) || isSubs(s,word)){
                set_pass.add(word);
                count++;
            } 
            else{
                set_fail.add(word);
            }
        }
        return count;
    }
    // this method giving better result 31ms
    private boolean isSubs(String s, String sbs){
        int fromIndex = 0;
        for(int el : sbs.toCharArray())
        {
            fromIndex = s.indexOf(el,fromIndex); //Heart of the code
            if(fromIndex++<0)return false;
        }
        return true;
    }
    //this method is taking 291ms
     public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        return isSubsequence(s,t,0,0);
    }
    public boolean isSubsequence(String s,String t, int index1,int index2){
        if(s.length()==index1) return true;
        if(t.length()==index2) return false;
        if(s.charAt(index1)==t.charAt(index2)){
            if(isSubsequence(s,t,index1+1,index2+1)) return true;
        }
        else{
            if(isSubsequence(s,t,index1,index2+1)) return true;
        }
        return false;
    }
}*/
class Solution {
    
    private class Node {
        char[] word;
        int index;
​
        public Node(String word, int index) {
            this.word = word.toCharArray();
            this.index = index;
        }
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        Queue<Node>[] dict = new LinkedList[128];
        for (int i = 'a'; i <= 'z'; i++)
            dict[i] = new LinkedList<>();
        for (String word : words)
            dict[word.charAt(0)].add(new Node(word, 0));
        int res = 0, n = words.length;
        for (char c : s.toCharArray()) {
            Queue<Node> q = dict[c];
              for (int j = q.size(); j > 0; j--) {
                Node node = q.poll();
                 if (++node.index == node.word.length) {
                    if (++res == n)
                        return res;
                } else
                   dict[node.word[node.index]].add(node);
            }
        }
​
        return res;
    }
    
}
