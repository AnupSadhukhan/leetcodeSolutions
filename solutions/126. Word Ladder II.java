class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        
        startSet.add(beginWord);
        bfs(startSet, endSet,map,dict,false);
        
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res,list,beginWord,endWord,map);
        
        return res;
    }
    private void dfs(List<List<String>> res,List<String> list,String word, String endWord, Map<String,List<String>> map){
        
        if(word.equals(endWord)){
            res.add(new ArrayList<>(list));
            return;
        }
        
        if(map.get(word)==null) return;
        for(String next : map.get(word)){
            list.add(next);
            dfs(res,list,next,endWord,map);
            list.remove(list.size()-1);
        }
    }
    
    
    private void bfs(Set<String> startSet, Set<String> endSet, Map<String,List<String>> map, Set<String> dict,boolean reversed){
        if(startSet.size()==0) return;
        
        if(startSet.size()> endSet.size()) {
            bfs(endSet,startSet,map,dict,!reversed);
            return;
        }
        Set<String> tmp = new HashSet<>();
        dict.removeAll(startSet);
        boolean finish =  false;
        for(String s : startSet){
            char[] chs = s.toCharArray();
            
            for(int i = 0;i < chs.length ; i++){
                char oldChar = chs[i];
                
                for(char c = 'a';c<='z';c++){
                    chs[i]=c;
                    String word = new String(chs);
                    
                    if(dict.contains(word)){
                        if(endSet.contains(word)){
                            finish = true;
                        }
                        else{
                            tmp.add(word);
                        }
