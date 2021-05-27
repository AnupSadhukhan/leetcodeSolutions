class Solution {
    public int minPartitions(String n) {
        char[] chs=n.toCharArray();
        // 33 ms
        /*boolean isPresent=true;
        int count=0;
        while(isPresent){
            isPresent=false;
            for(int i=0;i<chs.length;i++){
                //System.out.println("before "+chs[i]);
                if(chs[i]-'0'>0){
                    chs[i]=(char) (chs[i]-1);
                    //System.out.println("after "+chs[i]);
                    if(chs[i]-'0'>0) isPresent=true;
                }
            }
            count++;
        }
        return count; */
        //4ms
        int max=0;
        for(int i=0;i<chs.length;i++){
            max=Math.max(max,chs[i]-'0');
        }
        return max;
    }
}
