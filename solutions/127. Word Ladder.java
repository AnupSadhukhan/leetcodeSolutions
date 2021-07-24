class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set =  new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        int depth = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.remove(beginWord);
        while(!queue.isEmpty()){
            
            depth+=1;
            int levelSize = queue.size();
         
            for(int i = 0; i < levelSize ; i++){
                String word =  queue.poll();
                char[] chs = word.toCharArray();
                
                for(int j=0;j<chs.length;j++){
                    char oldChar =chs[j];
                    for(char c ='a';c<='z';c++){
                        chs[j] = c;
                        String newWord = new String(chs);
                        
                        if(chs[j]==oldChar || !set.contains(newWord)) continue;
                        
                        if(newWord.equals(endWord)) return depth+1;
                       
                        set.remove(newWord);
                        queue.offer(newWord);
                        
                    }
                    chs[j] = oldChar;
                }
                
            }
            
        }
        System.out.println("return 0");
        return 0;
    }
}
