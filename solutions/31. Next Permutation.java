class Solution {
    public void nextPermutation(int[] arr) {
       int idx=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }
        }
        List<Integer> li=new ArrayList<Integer>();
        if(idx==-1){
           
           reverse(arr,0,arr.length-1);
            
            return;
           
        }
        for(int i=arr.length-1;i>idx;i--){
            if(arr[i]>arr[idx]){
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
                break;
            }
        }
       reverse(arr,idx+1,arr.length-1);
        
       
    }
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }
    }
}
