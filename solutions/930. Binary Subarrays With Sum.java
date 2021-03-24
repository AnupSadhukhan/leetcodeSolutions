class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int ilo=0,ihi=0;
        int sumLo=0,sumHi=0;
        int ans=0;
        
        for(int i=0;i<A.length;i++){
            sumLo+=A[i];
            while(sumLo>S && ilo<i){
                sumLo-=A[ilo++];
            }
            sumHi+=A[i];
            while(ihi<i && (sumHi>S || (sumHi==S && A[ihi]==0))){
                sumHi-=A[ihi++];
            }
            if(sumLo==S)
            ans+=(ihi-ilo+1);
        }
        return ans;
    }
}
