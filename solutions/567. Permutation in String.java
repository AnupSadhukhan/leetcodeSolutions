class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] hash1=new int[26];
        for(char c : s1.toCharArray()){
            hash1[c-'a']++;
        }
        int[] hash2=new int[26];
        char[] chs = s2.toCharArray();
        int len = s1.length();
        int left = 0;
        for(int i=0;i<chs.length;i++){
            hash2[chs[i]-'a']++;
            if(i < len-1)
                continue;
            if(compareHashValue(hash1,hash2)) return true;
            hash2[chs[left++]-'a']--;
        }
        return false;
    }
    private boolean compareHashValue(int[] hash1,int[] hash2){
        for(int i = 0;i<hash1.length;i++){
            if(hash1[i]!=hash2[i]) return false;
        }
        return true;
    }
}
