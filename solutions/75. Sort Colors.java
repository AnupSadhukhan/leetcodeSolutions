class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int index1=-1;
        int index2=nums.length-1;
        int index3=nums.length;
        int tmp=-1;
        for(int i=0;i<=index2;i++){
            if(nums[i]==0){
                index1++;
                nums[i]=nums[index1];
                nums[index1]=0;
                if(index1<i)
                    i--;
           }
            else if(nums[i]==2){
                --index3;
              nums[i]=nums[index3];
                nums[index3]=2;
                i--;
               if(index2>=index3) index2=index3-1;
                
            }
            else{
                
                nums[i]=nums[index2];
                nums[index2]=1;
                i--;
                index2--;
            }
        }
    }
}
