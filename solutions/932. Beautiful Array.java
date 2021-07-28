class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        
        while(ans.size()<n){
            List<Integer> tmp = new ArrayList<>();
            for(int el : ans){
                if(2*el-1<=n){
                    tmp.add(2*el-1);
                }
            }
            for(int el : ans){
                if(2*el<=n){
                    tmp.add(2*el);
                }
            }
            ans = tmp;
        }
        int[] res = new int[n];
        for(int i = 0; i < n;i++){
            res[i] =  ans.get(i);
        }
        
        return res;
    }
}
