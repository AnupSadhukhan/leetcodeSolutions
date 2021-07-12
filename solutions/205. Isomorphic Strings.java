class Solution {
    //5ms
    public boolean isIsomorphic(String s, String t) {
        if(!helper(s,t)) return false;
        return true;
    }
    private boolean helper(String s,String t){
         int[] arr=new int[256];
        Arrays.fill(arr,-1);
        boolean[] considered=new boolean[256];
        for(int i=0;i<s.length();i++){
            int index=(int) s.charAt(i);
            if(arr[index]!=-1 && arr[index]!=t.charAt(i)) return false;
            else if(arr[index]!=-1 && arr[index]==t.charAt(i)) continue;
            else{
                if(considered[t.charAt(i)]) return false;
                arr[index]=(int) t.charAt(i);
                considered[t.charAt(i)]=true;
            }
        }
        return true;
    }
   
    // 8ms
    /* public boolean isIsomorphic(String s, String t) {
       if(!helper(s,t)) return false;
       if(!helper(t,s)) return false;
        return true;
    }
    private boolean helper(String s,String t){
         int[] arr=new int[256];
        Arrays.fill(arr,-1);
        for(int i=0;i<s.length();i++){
            int index=(int) s.charAt(i);
            if(arr[index]!=-1 && arr[index]!=t.charAt(i)) return false;
            else{
                arr[index]=(int) t.charAt(i);
                considered[t.charAt(i)]=true;
            }
        }
        return true;
    }*/
}
