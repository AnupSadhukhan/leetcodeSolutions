class Solution {
    class TrieNode{
        TrieNode[] childs;
       
        TrieNode(){
            childs=new TrieNode[2];
        }
    }
    TrieNode root=new TrieNode();
    public int findMaximumXOR(int[] nums) {
        /*
       int max=0,mask=0;
        
        for(int i=31;i>=0;i--){
             mask |= (1 << i);
            Set<Integer> set=new HashSet<Integer>();
            for(int num : nums){
                set.add(mask&num);
            }
            int tmp= max | (1<<i);
            for(int x : set){
                if(set.contains(x^tmp)){ //a^b=c means b=a^c
                    max=tmp;
                    break;
                }
            }
        }
        return max;
        
        */
        /* using trie */
        for(int num : nums)
        {
            insert(num);
        }
        int max=Integer.MIN_VALUE;
        for(int num :nums){
            max=Math.max(max,findMaxXor(num));
        }
        return max;
