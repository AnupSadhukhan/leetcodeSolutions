class Solution {
    // It is basically a backtracking problem,
    // there will be total 2*n chars to make n pairs of valid parenthese
    // we will keep track of open and close bracket, as long as
    // open bracket is less than n, we can always open bracket 
    // if close is less than open bracket to make string valid, we 
    // have to close it aswell
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        backtrack("",0,0,n);
        return res;
    }
    public void backtrack(String s,int open,int close,int n){
        if(s.length()==2*n){
            res.add(s);
        }
        if(open<n){
            backtrack(s+"(",open+1,close,n);
        }
        if(close<open){
            backtrack(s+")",open,close+1,n);
        }
    }
}
