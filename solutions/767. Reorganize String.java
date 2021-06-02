class Solution {
   /* map chars to 26 char array and count frequecy of every chars
     also keep a track of higest frequency and char.
     if number of other chars is less max-1 return empty string because 
     we can not arrange, e.g. aaab can not be arranged, aab can be arrange to aba
     
     else  we will place higest frequency char in alternate position i.e. index+2 pos
     once it is done, we take all other char and put them alter gap or blank position
     if index reaches end of char array, initialize it to 1 because we have to max freq
     char at 0,2,4,..
     */     
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
