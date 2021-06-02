class Solution {
    /*  we will keep track of last higest rating children or peak in graph( if at any
        sccenario we have to increase hight, then left childrens of last highest rating or peak 
        will not have any impact. we will keep track of candy given to last children, last higest
        rating children and candy given to last higest rating children i.e. last peak)
        case I : rating of cur children is greater than previous
            we will give one more extra candy than last children
            update last higest rating position
            update candy given to last highest rating children
            update candy given to last children irrespective of rating
        case II : rating of cur children is less than previous one
            to minimize candy distribution we will alway try to give 1 candy here
            if there many children between last higest rating children and cur and
            we have to give one extra candy to all of them to maintain condition
            if last higest rating children and next to last highest rating children or peak
            hold same number of candies, we have to give one candy to last higest rating or peak
            children.
            update candy given
            update candy given to last children irrespective of rating
        case III : rating of cur children is same as last children
            we will give 1 candy to minimize distribution and maintain condition
            update update last higest rating position to cur bcz this children too
            hold same rating,
            update candy given to last highest rating children
            update candy given to last children irrespective of rating
    */
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
            }
            if(ratings[i]<ratings[i-1]){
                candy[i]=1;
                lastCandy=1;
                int dist=i-lastPos;
                 candy[i]+=dist-1;
                if(candy[lastPos]<=dist)
                   candy[lastPos]+=1;
