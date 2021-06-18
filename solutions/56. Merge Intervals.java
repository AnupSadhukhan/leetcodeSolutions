class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        List<int[]> list=new ArrayList<>();
        
        int left=intervals[0][0];
        int right=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            
            
            if(intervals[i][0]>=left && intervals[i][0]<=right){
                right=Math.max(right,intervals[i][1]);
                
            }
            else{
              
                list.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        list.add(new int[]{left,right});
        int[][] res=new int[list.size()][2];
        int i=0;
        for(int[] arr : list){
            res[i]=arr;
            i++;
        }
        return res;
    }
}
