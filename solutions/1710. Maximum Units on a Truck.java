class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
       /* a=[1,3]
        b=[2,2]
            a[1]=3*/
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int i=0;
        int units=0;
        while(i<boxTypes.length && truckSize>0){
            int size=Math.min(boxTypes[i][0],truckSize);
            truckSize-=size;
            units+=(size*boxTypes[i][1]);
            i++;
        }
       
        return units;
        
        
    }
}
