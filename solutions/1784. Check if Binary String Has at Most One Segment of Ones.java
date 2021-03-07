class Solution {
    public boolean checkOnesSegment(String s) {
       
        char[] arr=s.toCharArray();
        //boolean state=true;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]=='0' && arr[i]=='1') return false;
        }
        return true;
    }
}
