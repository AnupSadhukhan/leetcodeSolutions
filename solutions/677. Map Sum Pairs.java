class MapSum {
    class TrieNode{
        int sum;
        Map<Character,TrieNode> map;
        TrieNode(char c,int sum){
            map=new HashMap<Character,TrieNode>();
            this.sum=sum;
        }
    }
​
    /** Initialize your data structure here. */
    TrieNode node=null;
    Map<String,Integer> map=null;
    public MapSum() {
        node=new TrieNode('1',-1);
        map=new HashMap<String,Integer>();
    }
    
    public void insert(String key, int val) {
        TrieNode x=node;
       
        Integer value=map.get(key);
        for(char c : key.toCharArray()){
            TrieNode cur=x.map.get(c);
            if(cur!=null){
               
                if(value!=null){
                    cur.sum-=value;
                    
                }
                cur.sum+=val;
               
            }
            else{
                x.map.put(c,new TrieNode(c,val));
            }
            x=x.map.get(c);
        }
        //int prev
        map.put(key,val);
       
    }
    
    public int sum(String prefix) {
        TrieNode x=node;
        for(char c : prefix.toCharArray()){
           if(x.map.get(c)== null) return 0;
            x=x.map.get(c);
        }
        return x.sum;
    }
}
​
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
