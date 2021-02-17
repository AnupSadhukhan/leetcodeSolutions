class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int low=0;
        int high=height.length-1;
        int area=0;
        int w=0,h=0;
        while(low<high){
            w=high-low;
            if(height[low]<=height[high]){
                area=height[low]*w;
                low++;
            }
            else if(height[low]>height[high]){
                area=height[high]*w;
                high--;
            }
            max=max<area?area:max;
        }
        return max;
    }
}
