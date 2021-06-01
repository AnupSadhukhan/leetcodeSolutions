class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[1]-b[1]);
       Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int[] x=map.getOrDefault(nums[i],new int[]{nums[i],0});
            
            if(!queue.isEmpty()){
                    queue.remove(x);
             }
            x[1]++;
            map.put(nums[i],x);
            if(queue.size()<k){
                
                queue.add(x);
            }
            else if(queue.size()>=k && queue.peek()[1]<x[1]){
                queue.poll();
                queue.add(x);
            }
            
        }
                int[] res=new int[k];
        /*for(int i=0;i<k;i++){
            res[i]=i;
        }*/
            int i=0;
            while(!queue.isEmpty() && i<k){
                    res[i++]=queue.poll()[0];
                }
       /* for(int x: res){
            System.out.print(x+" ");
        }
        System.out.println("\n");*/
                return res;
    }
}
