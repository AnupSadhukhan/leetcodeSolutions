class Solution {
    public int titleToNumber(String columnTitle) {
       char[] chs = columnTitle.toCharArray();
        int mul =1;
        int num = 0;
        for(int i=chs.length-1;i>=0;i--){
            int pos = (chs[i]-'A') + 1;
            num+=(mul*pos);
            mul*=26;
        }
        return num;
    }
}
