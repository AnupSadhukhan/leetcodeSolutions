class Solution {
    /* approch 1 */
    
    class TrieNode{
        
        boolean eh;
        Map<Character,TrieNode> map;
        TrieNode(){
            eh=false;
            map=new HashMap<Character,TrieNode>();
        }
    }
    TrieNode node=new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {
        insert(dictionary);
        StringBuilder sb=new StringBuilder();
        for(String word : sentence.split("\\s")){
            String s = search(word);
            if(s==null){
                sb.append(word+" ");
            }
            else sb.append(s+" ");
            
        }
        return sb.toString().trim();
    }
    public void insert(List<String> dic){
        for(String word : dic){
            TrieNode x=node;
            for(char c : word.toCharArray()){
                TrieNode cur=x.map.get(c);
                if(cur==null){
                    x.map.put(c,new TrieNode());
                }
                x=x.map.get(c);
            }
            x.eh=true;
        }
    }
    public String search(String word){
        TrieNode x=node;
        StringBuilder sb=new StringBuilder();
        for(char c : word.toCharArray()){
            TrieNode cur=x.map.get(c);
            if(cur==null) return null;
            else if(cur.eh) {
                sb.append(c);
                return sb.toString();
            }
            sb.append(c);
            x=x.map.get(c);
        }
        if(x.eh) return sb.toString();
        return null;
    }
    
    
    /* approch 2 */
   /* public String replaceWords(List<String> dictionary, String sentence) {
