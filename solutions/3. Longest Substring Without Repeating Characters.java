class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        if(s==null || s.length()==0) return len;
        int[] arr=new int[256];
        char[] chs=s.toCharArray();
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(arr[chs[i]]==0){
                arr[chs[i]]++;
                len++;
                
            }
            else{
                while(left<i && arr[chs[i]]>0){
                    arr[chs[left++]]--;
                    len--;
                }
                arr[chs[i]]++;
                len++;
            }
            max=max<len?len:max;
        }
        return max;
    }
}
