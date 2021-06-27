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
    /* 
        //1ms 2 pass O(n)
    
       int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }
​
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
​
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i],candy[i + 1] + 1);
            }
        }
​
        int count = 0;
        for (int i = 0; i < candy.length; i++) {
            count += candy[i];
        }
​
        return count;
    */
    
    //2ms single pass o(1) space
     int lastPeakPos=0;
        int lastCandy=1;
        int totalCandy=1;
        int lastPeakCandy=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>=ratings[i-1]){
                if(ratings[i]==ratings[i-1]){
                    lastCandy=1;
                }
                else{
                    lastCandy+=1;
                }
                totalCandy+=lastCandy;
                lastPeakPos=i;
                lastPeakCandy=lastCandy;
            }
           else{
                int dist=i-lastPeakPos;
                lastCandy=1;
