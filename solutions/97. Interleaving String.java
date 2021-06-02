class Solution {
    boolean[][] checked;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        if(s1==null && s2==null && s3==null) return true;
        if(s1.equals("") && s2.equals("") && s3.equals("")) return true;
        if((s1.equals("") && (s2.equals(s3))) || (s2.equals("") && (s1.equals(s3)))) return true;
        char[] chs1=s1.toCharArray();
        char[] chs2=s2.toCharArray();
        char[] chs3=s3.toCharArray();
        int left1=0,left2=0,left3=0;
        checked=new boolean[chs1.length+1][chs2.length+1];
        return helper(chs1,chs2,chs3,left1,left2,left3);
    }
    public boolean helper(char[] chs1,char[] chs2,char[] chs3,int left1,int left2,int left3){
        //if(left1+left2!=left3 ) return false;
        if(left1==chs1.length && left2==chs2.length && left3==chs3.length) return true;
        if(checked[left1][left2]) return false;
        if(left1<chs1.length && chs3[left3]==chs1[left1]){
            if(helper(chs1,chs2,chs3,left1+1,left2,left3+1)) return true;
        }
        if(left2<chs2.length && chs2[left2]==chs3[left3]){
            if(helper(chs1,chs2,chs3,left1,left2+1,left3+1)) return true;
        }
        checked[left1][left2]=true;
        return false;
    }
}
