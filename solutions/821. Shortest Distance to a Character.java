class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] ans=new int[s.length()];
        char[] arr=s.toCharArray();
        int last=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
           
                if(arr[i]==c){
                    ans[i]=0;
                    last=i;
                }
                else if(last!=Integer.MAX_VALUE){
                    ans[i]=i-last;
                }
            else{
                ans[i]=Integer.MAX_VALUE;
            }
        }
       /*  System.out.println("After 1st");
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }*/
        last=Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==c){
                    ans[i]=0;
                    last=i;
            }
            else{
                ans[i]=Math.min(ans[i],last-i);
            }
            
        }
        /*System.out.println("After 2nd");
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }*/
        return ans;
    }
}
