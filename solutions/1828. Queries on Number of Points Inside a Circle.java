class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result=new int[queries.length];
        int i=0;
        for(int[] query : queries){
            // System.out.println("query - "+(i+1));
            int count=0;
            for(int[] point : points){
                if(isInsideEuclideanDistance(point[0],point[1],query[0],query[1],query[2])) count++;
            }
            result[i++]=count;
        }
        return result;
    }
    private boolean isInsideEuclideanDistance(int x1,int y1,int x2,int y2,int radius){
        
        
        int dist=((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        
        return radius*radius>=dist;
    }
}
