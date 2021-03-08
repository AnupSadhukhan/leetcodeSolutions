class WordDictionary {
    class TrieNode{
        char c;
        int eh;
        TrieNode[] childs;
        TrieNode(char c){
            this.c=c;
            childs=new TrieNode[26];
        }
        
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode('1');
    }
    
    public void addWord(String word) {
        TrieNode x=root;
        for(char c : word.toCharArray()){
            if(x.childs[c-'a']==null){
                x.childs[c-'a']=new TrieNode(c);
            }
            x=x.childs[c-'a'];
        }
        x.eh++;
    }
    
    public boolean search(String word) {
        TrieNode x=root;
        char[] arr=word.toCharArray();
        //System.out.println("### word "+word);
        return searchWord(x,arr,0);
    }
    public boolean searchWord(TrieNode x,char[] arr,int start){
        //System.out.println("start "+start);
        for(int idx=start; idx<arr.length;idx++){
            //System.out.println("idx "+idx+" char "+arr[idx]);
            if(arr[idx]=='.'){
                 //System.out.println("if cond ");
                for(int i=0;i<26;i++){
                    boolean first=false;
                    if(x.childs[i]!=null){
                        
                    first=(idx==arr.length-1 && x.childs[i].eh>0);
                        // System.out.println("first part "+first+" and char "+x.childs[i].c);
                      
                    }
                    
                    if(x.childs[i]!=null && (first || searchWord(x.childs[i],arr,idx+1) )){
                        
                        //System.out.println("1. true at idx "+idx);
                        return true;
                    }
                }
                return false;
            }
            else{
                //System.out.println("else cond ");
                TrieNode cur=x.childs[arr[idx]-'a'];
                if(cur==null) return false;
               
                x=x.childs[arr[idx]-'a'];
                if(idx==arr.length-1 && x.eh>0){
                    //System.out.println("2. true at idx "+idx);
                    return true;
                } 
            }
        }
        return false;
        
    }
}
​
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
