class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //18 ms
        /*List<int[]> distance=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int dist=Math.abs(arr[i]-x);
            distance.add(new int[]{dist,arr[i]});
        }
        distance.sort((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        Integer[] kClosestElms=new Integer[k];
        for(int i=0;i<k;i++){
            kClosestElms[i]=distance.get(i)[1];
        }
        Arrays.sort(kClosestElms);
        return Arrays.asList(kClosestElms);*/
        
        //7ms
       /* LinkedList<Integer> result=new LinkedList<>();
        
        int index=Arrays.binarySearch(arr,x);
         if(index>=0)
         result.add(x);
        int left=index-1;
        int right=index+1;
        if(index<0){
            index=-(index+1);
            left=index-1;
            right=index;
            
        }
        
       
        while(result.size()<k && (left>=0 || right <arr.length)){
            int dist1=left>=0?Math.abs(arr[left]-x):Integer.MAX_VALUE;
            int dist2=right<arr.length?Math.abs(arr[right]-x):Integer.MAX_VALUE;
            if(dist1<=dist2 && left>=0){
                result.addFirst(new Integer(arr[left--]));
            }
            else if(right<arr.length) result.addLast(new Integer(arr[right++]));
        }
        return new ArrayList<>(result);*/
        
        List<Integer> result=new ArrayList<>();
        if(x<arr[0]){
            int[] copy=Arrays.copyOfRange(arr,0,k);
            for(int i=0;i<k;i++){
                result.add(copy[i]);
            }
            return result;
        }
        else if(x>arr[arr.length-1]){
             int[] copy=Arrays.copyOfRange(arr,arr.length-k,arr.length);
            for(int i=0;i<k;i++){
                result.add(copy[i]);
            }
            return result;
        }
        int index=Arrays.binarySearch(arr,x);
        int left=index-1;
        int right=index+1;
        if(index<0){
            index=-(index+1);
            left=index-1;
            right=index;
            
        }else k--;
        while(k>0 && (left>=0 || right <arr.length)){
            int dist1=left>=0?Math.abs(arr[left]-x):Integer.MAX_VALUE;
            int dist2=right<arr.length?Math.abs(arr[right]-x):Integer.MAX_VALUE;
            if(dist1<=dist2 && left>=0){
                left--;
            }
            else if(right<arr.length) right++;
            k--;
        }
        for(int i=left+1;i<right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
