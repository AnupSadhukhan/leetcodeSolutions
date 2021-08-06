/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
​
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1,right = n;
        int count = 0;
        while(left<=right){
           
            int mid = (right-left)/2 + left;
            if(isBadVersion(mid))  right = mid-1;
            else left = mid+1;
           
        }    
        //System.out.println(count+" "+left+" "+right);
        return left;
    }
    
}
