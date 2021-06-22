class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        return isSubsequence(s,t,0,0);
    }
    public boolean isSubsequence(String s,String t, int index1,int index2){
        if(s.length()==index1) return true;
        if(t.length()==index2) return false;
        if(s.charAt(index1)==t.charAt(index2)){
            if(isSubsequence(s,t,index1+1,index2+1)) return true;
        }
        else{
            if(isSubsequence(s,t,index1,index2+1)) return true;
        }
        return false;
    }
}
