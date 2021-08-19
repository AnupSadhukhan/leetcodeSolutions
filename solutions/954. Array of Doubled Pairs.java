class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int count = 0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            
            int x = arr[i];
                
            if(map.get(x)!=null && map.get(2*x)!=null){
                
                if(x==2*x && map.get(x)<=1) continue;
                //System.out.println(x+" : "+(2*x));
                Integer freq1 = map.get(x);
                if(freq1==1){
                    //System.out.println("1. Remove "+x);
                    map.remove(x);
                } 
                else{
                   //System.out.println("1. Reduce by 1 => "+x+" put "+(freq1-1));
                    map.put(x,freq1-1);
                } 
                
                Integer freq2 = map.get(2*x);
                if(freq2==1){
                     //System.out.println("2. Remove "+(2*x));
                    map.remove(2*x);
                } 
                else{
                   //System.out.println("2. Reduce by 1 => "+(2*x)+" put "+(freq2-1));
                    map.put(2*x,freq2-1);
                } 
                
                count++;
            }
            
        }
        return count == arr.length/2;
    }
}
