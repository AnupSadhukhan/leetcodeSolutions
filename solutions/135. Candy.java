class Solution {
    // if rating is greater than the previous children then we will add
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        int candy=1; // it will hold min num of candy
        int lastPosCandy=1; // lastPoscandy is the last peak position
        int lastPos=0;
        int lastCandy=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy+=lastCandy+1;
                lastPosCandy=lastCandy+1;
                lastCandy++;
                lastPos=i;
                
            }
            if(ratings[i]<ratings[i-1]){
                candy+=1;
                lastCandy=1;
                int dist=i-lastPos;
                candy+=dist-1;
                if(lastPosCandy<=dist){
                    lastPosCandy+=1;
                    candy++;
                }
                   
            }
            if(ratings[i]==ratings[i-1]){
                candy+=1;
                lastCandy=1;
                lastPosCandy=1;
                lastPos=i;
            }
           
        }
        return candy;
        /*int[] candy=new int[ratings.length];
        int lastPos=0;
        int lastCandy=1;
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=lastCandy+1;
                lastCandy++;
                lastPos=i;
