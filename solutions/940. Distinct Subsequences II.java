class Solution {
    public int distinctSubseqII(String S) {
        if(S.equals("") || S==null) return 0;
        int mod=1000000007;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),-1);
        }
        int withCount=0;
        int totalCount=0;
        for(int i=0;i<S.length();i++){
            if(i==0){
                withCount=1;
                totalCount=1;
                map.put(S.charAt(i),withCount);
                continue;
            }
            withCount=(totalCount+1)%mod;
            Integer num=map.get(S.charAt(i));
            if(num==-1){
                
                totalCount=((mod+withCount)%mod+(mod+totalCount)%mod)%mod;
            }
            else{
                totalCount=(mod+((mod+withCount)%mod+(mod+totalCount)%mod)%mod-num)%mod;
            }
            map.put(S.charAt(i),withCount);
        }
        return totalCount%mod;
    }
}
