class Solution {
    // O(n) O(1)
    private final int[] IMPOSSIBLE = {-1,-1};
    public int[] threeEqualParts(int[] arr) {
        int n=arr.length;
        int numOfOnes = 0;
        for(int elm : arr){
            numOfOnes+=elm;
        }
        int numOfOnesForEachBlock = numOfOnes / 3;
        if(numOfOnes%3 != 0) return IMPOSSIBLE;
        
        if(numOfOnesForEachBlock==0) return new int[]{0,n-1};
        
        int i = 0;
        while(arr[i]==0){
            i++;
        }
        int m=i,c=0;
        while(c<numOfOnesForEachBlock || arr[m]==0){
            c+=arr[m++];
        }
        int j=m;
        c=0;
        while(c<n && (c<numOfOnesForEachBlock || arr[j]==0)){
            c+=arr[j++];
        }
        
        while(j<n && arr[i]==arr[m] && arr[m]==arr[j]){
            i++;
            j++;
            m++;
        }
        if(j!=n) return IMPOSSIBLE;
        
        return new int[] {i-1,m};
    }
}
