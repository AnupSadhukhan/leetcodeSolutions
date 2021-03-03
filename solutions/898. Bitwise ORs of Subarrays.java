class Solution {
    public int subarrayBitwiseORs(int[] arr) {
       Set<Integer> set1=new HashSet<Integer>();
       Set<Integer> ans=new HashSet<Integer>();
       for(int i=0;i<arr.length;i++){
           Set<Integer> cur=new HashSet<Integer>();
           cur.add(arr[i]);
           for(int x : set1){
               cur.add(arr[i] | x);
           }
           set1=cur;
           ans.addAll(cur);
       }
        return ans.size();
    }
}
