class Solution {
    public boolean isAlienSorted(String[] words, String order) {
         int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        Set<String> set=new HashSet<String>();
        StringBuilder sb=new StringBuilder();
        for(String str : words){
            sb.append(str+"-");
        }
        set.add(sb.toString());
        Arrays.sort(words,(a,b)->{
            int i=0;
            int len1=a.length();
            int len2=b.length();
            while(i<len1 && i<len2){
                int diff=map[a.charAt(i)-'a']-map[b.charAt(i)-'a'];
                if(diff<0){
                    return -1;
                }
                else if(diff>0) return 1;
                i++;
            }
            return len1-len2;
        });
            sb=new StringBuilder();
            for(String s : words){
               // System.out.println(s);
                sb.append(s+"-");
            }
        return set.contains(sb.toString());
    }
   
}
