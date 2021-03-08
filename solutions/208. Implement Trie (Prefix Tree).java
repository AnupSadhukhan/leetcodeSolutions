class Trie {
    class T{
        char c;
        int eh;
        int preC;
        T[] child;
        T(char c){
            eh=0;
            child=new T[26];
            preC=1;
            this.c=c;
        }
    }
    /** Initialize your data structure here. */
    T trie=null;
    public Trie() {
        trie=new T('1');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        T cur=trie;
        for(char c : word.toCharArray()){
            if(cur.child[c-'a']!=null){
                cur.preC++;
               
                
            }
            else{
                cur.child[c-'a']=new T(c);
               
            }
             cur=cur.child[c-'a'];
        }
        cur.eh++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        T cur=trie;
        for(char c : word.toCharArray()){
           if(cur.child[c-'a']==null){
               return false;
                
            }
              cur=cur.child[c-'a'];
        }
        if(cur.eh>0) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        T cur=trie;
        for(char c : prefix.toCharArray()){
           if(cur.child[c-'a']==null){
               return false;
                
            }
