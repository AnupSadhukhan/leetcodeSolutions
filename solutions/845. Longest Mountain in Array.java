class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length<3) return 0;
        int max=0;
        int lastDownPoint=-1;
        int downPoint=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1] && downPoint!=-1){
               
                    lastDownPoint=downPoint;
                    downPoint=-1;
                
            }
            else if(arr[i]<arr[i-1]){
                downPoint=i;
                if(lastDownPoint!=-1){
                    max=Math.max(max,downPoint-lastDownPoint+1);
                }
            }
            else if(arr[i]==arr[i-1]){
                lastDownPoint=-1;
                downPoint=i;
            }
        }
        return max;
        
       
    }
}
