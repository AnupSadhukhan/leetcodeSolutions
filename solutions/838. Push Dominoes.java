class Solution {
    public String pushDominoes(String dominoes) {
        char[] chs = dominoes.toCharArray();
        int[] arr = new int[chs.length];
        int dist = 0;
        for(int i = 0;i<arr.length;i++){
            if(chs[i] == 'R'){
                dist=1;
            }
            if(chs[i] == '.' && dist>0){
                arr[i]= dist;
                dist++;
            }
            if(chs[i]=='L') dist = 0;
        }
        dist = 0;
        for(int i=arr.length-1;i>=0;i--){
            if(chs[i] == 'R'){
                dist=0;
            }
             if(chs[i]=='L') dist = 1;
            if(chs[i] == '.' ){
                //if(arr[i])
                if(arr[i]>0 && dist==0) chs[i]='R';
                else if(arr[i]==0 && dist>0) chs[i]='L';
                else if(arr[i]>dist) chs[i]='L';
                else if(arr[i]<dist) chs[i] = 'R';
                if(dist>0)
                    dist++;
            }
           
        }
        return new String(chs);
    }
}
