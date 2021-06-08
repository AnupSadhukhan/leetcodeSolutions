        Set<String> set=new HashSet<>();
        set.add(new String(arr,0,26));
        int n=p.length();
        char[] chs=s.toCharArray();
        arr=new int[26];
        for(int i=0;i<chs.length;i++){
            
            arr[chs[i]-'a']++;
           
            if(i>=n){
                arr[chs[i-n]-'a']--;
            }
            if(i>=n-1){
                if(set.contains(new String(arr,0,26))){
                    res.add(i-n+1);
                }
            }
        }
        return res;
    }*/
    //15ms
     public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int n = s.length();
        int m= p.length();
        if(n<m) return res;
         int[] arr=new int[26];
         for(char c : p.toCharArray()){
             arr[c-'a']++;
         }
         int left=0,right=0,count=m;
         
         for(char c :  s.toCharArray()){
             if(arr[c-'a']-->=1) count--;
           
             if(count==0) res.add(left);
             right++;
             if(right-left==m && arr[s.charAt(left++)-'a']++>=0) count++;
             
             
         }
         return res;
     }
}
