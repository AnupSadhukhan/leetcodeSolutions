class Solution {
     //  (c)  
  /* (D) /\
        /  \    => if there is mountain we need point A and B to calculate dist
      (A)   (B) => 
   
          /\  
   (c) __/  \   =>  intitally we may set d as last down point as we don't know
      / (a) (b) =>  future points, but at d there are two elements which has same
     /          => values, so it is not eligible for mountain, hence we have to 
    (d)         => reset lastdownpoint and set downpoint to a, which can be future downpoint
                => if next elements form mountain or next element is greater than i, then we 
                => update a as lastdownpoint and downpoint as -1 , so that even if next elem is
                => greater, it doesn't update lastdownpoint again, and next when our mountain
                => go down, at point b we will calculate dist as Math.max(prev_max_value, b-a+1)
    Complexity : O(n), space-> O(1)  
    */
    public int longestMountain(int[] arr) {
        if(arr.length<3) return 0;
        int max=0;
        int lastDownPoint=-1;
        int downPoint=0;
        for(int i=1;i<arr.length;i++){
            // if we see uphill first time means we don't know last down point
            // then we will set downpoint to -1 so that it never enter
            // this block as long as array is increasing and we will set
            
            if(arr[i]>arr[i-1] && downPoint!=-1){
               
                    lastDownPoint=downPoint;
                    downPoint=-1; 
                
            }
            else if(arr[i]<arr[i-1]){
                // if cur value is less than previous one then it is downfall
                // and this point can be future downpoint for another mountain
                // so set downpoint to i and if we had last down point then
                // calculate max distance
                downPoint=i;
                if(lastDownPoint!=-1){
                    max=Math.max(max,downPoint-lastDownPoint+1);
                }
            }
            else if(arr[i]==arr[i-1]){
                // if cur element is equal with previous one
                // then this can't be mountain as per condition
                // however this point can be next downpoint
                // update downpoint to i and lastdownpoint to -1
                // so that next time when we see downfall, we don't calculate distance
                // for mountain, it will be miscalculation
                lastDownPoint=-1;
                downPoint=i;
            }
        }
        return max;
        
       
    }
}
