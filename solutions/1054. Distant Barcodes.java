class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] hash = new int[10001];
        for(int barcode : barcodes){
            hash[barcode]++;
        }
        PriorityQueue<int[]> queue =  new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<10001;i++){
            if(hash[i]>0)
                queue.add(new int[]{i,hash[i]});
        }
        barcodes = new int[barcodes.length];
        int indx = 0;
        while(!queue.isEmpty()){
            int[] value = queue.poll();
            
            while(value[1]-->0){
              
                if(barcodes[indx]!=0) indx = (indx+1)%barcodes.length;
                barcodes[indx] = value[0];
               
                indx = (indx+2)%barcodes.length;
            }
        }
        return barcodes;
    }
}
