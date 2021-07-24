class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[2051];
        for(int[] log : logs){
            arr[log[0]]++;
            arr[log[1]]--;
        }
        int max=1950;
        for(int i = 1950;i<2051;i++){
            arr[i]+=arr[i-1];
            if(arr[i]>arr[max]) max=i;
        }
        return max;
    }
}
