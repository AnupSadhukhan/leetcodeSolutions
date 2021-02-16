class Solution {
    class Weak{
        int index;
        int weight;
        Weak(int index,int weight){
            this.index=index;
            this.weight=weight;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        List<Weak> li=new ArrayList<Weak>();
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[i][j];
            }
            li.add(new Weak(i,sum));
        }
       Collections.sort(li,(a,b)->{
           if(a.weight==b.weight){
               return a.index-b.index;
           }
           return a.weight-b.weight;
       });
           int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=li.get(i).index;
        }
        return res;
    }
}
