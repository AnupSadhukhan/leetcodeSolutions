class Solution {
    public int longestStrChain(String[] words) {
        if(words.length==0) return 0;
        Map<Integer,Map<String,Integer>> map=new HashMap<>();
        for(String word : words){
            int len=word.length();
            Map<String,Integer> chainMap=map.get(len);
            if(chainMap==null){
                chainMap=new HashMap<>();
                map.put(len,chainMap);
            }
            chainMap.put(word,1);
            
            
        }
         int max=1;
        for(int i=15;i>0;i--){
             //System.out.println("loop1");
            Map<String,Integer> chainMap=map.get(i);
            Map<String,Integer> nextChainMap=map.get(i+1);
            if(chainMap==null || nextChainMap==null) continue;
            for(Map.Entry<String,Integer> words1 : chainMap.entrySet()){
                //System.out.println("loop2");
                int curMax=1;
                char[] word1=words1.getKey().toCharArray();
                for(Map.Entry<String,Integer> words2 : nextChainMap.entrySet()){
                    // System.out.println("loop3");
                    char[] word2=words2.getKey().toCharArray();
                    int diff=0;
                    int k=0,j=0;
                    for(k=0,j=0;k<word1.length;j++){
                        // System.out.println("loop4");
                        if(word1[k]!=word2[j] ){
                            if(diff>0){
                               diff++;
                                break;
                            } 
                            diff++;
                        }
                        else k++;
                    }
                    if(diff<=1){
                        curMax=Math.max(words2.getValue()+1,curMax);
                    }
                }
                max=Math.max(curMax,max);
                
                chainMap.put(words1.getKey(),curMax);
            }
            
        }
        return max;
    }
}
