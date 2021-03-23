class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=1;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int count=0;
        for(int i=1;i<arr.length-1;i++){
            Integer freq=map.get(arr[i]);
            if(freq!=null && freq<=1){
                map.remove(arr[i]);
            }
            else if(freq!=null && freq>1){
                map.put(arr[i],freq-1);
            }
            for(int j=i-1;j>=0;j--){
                //System.out.println("sum "+(arr[i]+arr[j]));
                if(arr[i]+arr[j]<=target){
                    count=(count+map.getOrDefault(target-arr[i]-arr[j],0))%1000000007;
                }
            }
        }
        return count;
    }
}
