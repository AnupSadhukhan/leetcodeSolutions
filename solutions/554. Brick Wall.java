class Solution {
    // As after adding all bricks all row's value becoming same, and in problem it is told not 
    // to consider those two edge, first and last of the wall. so, for each rowm we will create a sum and put 
    // that in hashmap one by one, and we will keep the frequency of sum also in hashmap. We will take max freq
    // in max variable. At the end we will retun row size - max, max will hold not crossing bricks
    // so to get least crossing bricks we have to minus this value with wall's height 
    public int leastBricks(List<List<Integer>> wall) {
        int m=wall.size();
      
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                sum+=wall.get(i).get(j);
                Integer freq=map.getOrDefault(sum,0)+1;
                max=Math.max(max,freq);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        return m-max;
    }
}
