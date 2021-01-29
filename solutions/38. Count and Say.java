class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        int i=1;
        
        String num="1";
        while(i++<n){
            char[] arr=num.toCharArray();
            int c=1;
            int k=0;
            StringBuilder sb=new StringBuilder();
            for( k=1;k<arr.length;k++){
                if(arr[k]!=arr[k-1]){
                    sb.append(c+""+arr[k-1]);
                    c=1;
                }
                else{
                    c++;
                }
            }
            sb.append(c+""+arr[k-1]);
            num=sb.toString();
            //System.out.println(num);
            
        }
        return num;
    }
}
