class Solution {
  /*  class Trie{
        int idx;
        List<Integer> li;
        Trie[] child;
        Trie(){
            this.idx=-1;
            li=new ArrayList<Integer>();
            child=new Trie[26];
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        if(words==null || words.length<2) return res;
        
        Trie root=new Trie();
        
        for(int i=0;i<words.length;i++){
            add(words[i].toCharArray(),root,i);
        }
        for(int i=0;i<words.length;i++){
            
        }
        return res;
    }
    public void search(String[] words,int i,Trie root,List<List<Integer>> res){
        for(int j=0;j<words[i].length();j++){
            if(root.idx>=0 && root.idx!=i && isPalindrome(words[i].toCharArray(),j,words[i].length()-1)){
                res.add(Arrays.asList(i,root.idx));
            }
            root=root.child[words[i].charAt(j)-'a'];
            if(root==null ) return;
            
        }
        
        for(int j : root.li){
            if(i==j) continue;
            res.add(Arrays.asList(i,j));
        }
    }
    public void add(char[] arr,Trie root,int index){
        for(int i=arr.length-1;i>=0;i--){
            if(root.child[arr[i]-'a']==null){
                root.child[arr[i]-'a']=new Trie();
            }
            if(isPalindrome(arr,0,i)){
                root.li.add(index);
            }
            root=root.child[arr[i]-'a'];
        }
        
        root.li.add(index);
        root.idx=index;
        
    }
    public boolean isPalindrome(char[] arr,int start,int end){
        while(start<end){
            if(arr[start++]!=arr[end--]) return false;
        }
        return true;
    }
    */
    private static class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;
        
    TrieNode() {
        next = new TrieNode[26];
        index = -1;
        list = new ArrayList<>();
    }
}
    
public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();
​
    TrieNode root = new TrieNode();
        
    for (int i = 0; i < words.length; i++) {
        addWord(root, words[i], i);
    }
        
    for (int i = 0; i < words.length; i++) {
        search(words, i, root, res);
