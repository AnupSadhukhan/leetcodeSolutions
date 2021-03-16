class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    public void sort(int[] num,int start,int end){
        if(start>end || end==start) return;
        int mid=(start+end)/2;
        sort(num,start,mid);
        sort(num,mid+1,end);
        merge(num,start,mid,end);
    }
    public void merge(int[] arr,int start,int mid,int end){
        int[] left=new int[mid-start+1];
        int right[]=new int[end-mid];
        //System.out.println("mid "+mid+" start "+start+" end "+end);
        for(int i=start;i<=mid;i++){
            left[i-start]=arr[i];
        }
        for(int i=mid+1;i<=end;i++){
            //System.out.println("i-mid+1  "+(i-mid+1)+" i "+i+" mid+1 "+(mid+1));
            right[i-(mid+1)]=arr[i];
        }
        int index=start;
        int i=0,j=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[start++]=left[i++];
            }
            else{
                arr[start++]=right[j++];
            }
        }
        while(i<left.length){
            arr[start++]=left[i++];
        }
        while(j<right.length){
            arr[start++]=right[j++];
        }
    }
}
