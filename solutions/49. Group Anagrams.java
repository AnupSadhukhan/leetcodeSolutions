class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] arr = new int[26];
            for(char c : s.toCharArray()){
                arr[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(arr[i]>0){
                    char c = (char)(i+'a');
                    sb.append(c+"-"+arr[i]);
                }
            }
            List<String> list = map.get(sb.toString());
            if(list==null){
                list = new ArrayList<>();
                map.put(sb.toString(),list);
            }
            list.add(s);
            
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> m : map.entrySet()){
          result.add(m.getValue());   
        }
        return result;
    }
}
