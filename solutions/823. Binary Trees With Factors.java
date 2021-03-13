class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer,Long> map=new HashMap<Integer,Long>();
        Arrays.sort(arr);
        int mod=1000000007;
        long ans=0l,cur_ans;
        for(int i=0;i<arr.length;i++){
            cur_ans=1;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]!=0) continue;
                Long num1=map.get(arr[j]);
                Long num2=map.get(arr[i]/arr[j]);
                if(num1!=null && num2!=null)
                cur_ans=(cur_ans+(num1*num2)%mod)%mod;
            }
            map.put(arr[i],cur_ans);
            ans=(ans+cur_ans)%mod;
        }
        return (int)ans;
    }
}
