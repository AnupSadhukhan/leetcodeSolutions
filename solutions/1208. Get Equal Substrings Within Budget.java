class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        int left=0;
        int max=0;
        int cost=0;
        for(int i=0;i<c1.length;i++){
            if(c1[i]!=c2[i]){
                cost+=Math.abs((int)c1[i]-(int)c2[i]);
            }
            while(left<=i && cost>maxCost){
                cost-=Math.abs((int)c1[left]-(int)c2[left]);
                left++;
            }
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}
