class Solution {
    public String largestNumber(int[] nums) {
        
        //List<String> list=new ArrayList<>();
        String[] arr=new String[nums.length];
        int i=0;
        for(int num : nums){
            arr[i]=num+"";
            i++;
        }
        /*Collections.sort(list,(a,b)->{
          
            return (b+a).compareTo(a+b);
        }); */
       Arrays.sort(arr,(a,b)->{
           
            return (b+a).compareTo(a+b);
        });
          
        
        
        
        
        StringBuilder sb=new StringBuilder();
        for(String elm :  arr){
            sb.append(elm);
        }
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
