class Solution {
   
    public String reorganizeString(String s) {
        if(s==null || s.equals("")) return "";
        int[] letter=new int[26];
        int max=0,maxIndex=0;
        char[] chs=s.toCharArray();
        for(char c : chs){
            ++letter[c-'a'];
            if(max<letter[c-'a']){
                max=letter[c-'a'];
                maxIndex=c-'a';
            }
            
        }
        //System.out.println("max"+max+" maxIndex "+maxIndex);
        if(s.length()-max<max-1) return "";
        int idx=0;
        char[] arr=new char[s.length()];
        while(letter[maxIndex]>0){
            arr[idx]=(char)(maxIndex+'a');
            idx+=2;
            letter[maxIndex]--;
        }
        for(int i=0;i<26;i++){
            while(letter[i]>0){
                if(idx>=chs.length){
                    idx=1;
                }
                arr[idx]=(char)(i+'a');
                idx+=2;
                letter[i]--;
            }
        }
        return new String(arr);
        
        
    }
}
