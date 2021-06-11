class Solution {
    /*  Approch 1: brute force
        if the char is not zero, reduce by 1 and if it is zero reduce by zero
        do the same for whole string repeatedly until string is left with zero only
        that n="32" => "11" +"11" +"10"
        Approch 2:
        from above approch we can see that loop is running at most 3 time,
        which is max value in the string, so we can reduce the process just 
        by iterating only once and finding max char, and it will be our ans
    */
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
