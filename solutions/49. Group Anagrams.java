class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s : strs){
            char[] chs=s.toCharArray();
            int[] hash=new int[26];
            for(char c : s.toCharArray()){
                hash[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++){
                if(hash[i]>0){
                    char c=(char)(i+'a');
                    sb.append(c+"-"+hash[i]);
                }
            }
            List<String> list=map.get(sb.toString());
            if(list==null){
                list=new ArrayList<>();
                map.put(sb.toString(),list);
            }
            list.add(s);
            
        }
        List<List<String>> result=new ArrayList<>();
        for(String key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}
