class Solution {
    //O(nlogn) -> we will put all the elements into max priorityQueue 
    // each time, we will pop out max element, decrement it by sum of rest of elemnts
    // then add new decreamented element into the queue. we will process this until 
    // sum becomes less than or equal to length of array( bcz target array is all ones)
    // if sum is equal to length of array return true or false;
    // how simply decrement will take time, if a number is very large
    // so, we can use % to decrement value all at once by sum of rest elms, 
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        int  cur=target.length;
        int sum=0;
        
        for(int i=0;i<target.length;i++){
            sum+=target[i];
            queue.offer(target[i]);
        }
        while(cur<sum){
            int elm=queue.poll();
            sum-=elm;
            if(elm==1 || sum==1) return true;
            if(elm<sum || sum==0 || elm%sum==0) return false;
            int tmp=elm%(sum);
            sum=sum+tmp;
            queue.offer(tmp);
        }
        return cur==sum;
    }
}
