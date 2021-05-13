class Solution {
    /*
    We can split S to two parts for two coordinates.
    Then we use sub function f to find all possible strings for each coordinate.
​
    In sub functon f(S)
    if S == "": return []
    if S == "0": return [S]
    if S == "0XXX0": return []
    if S == "0XXX": return ["0.XXX"]
    if S == "XXX0": return [S]
    return [S, "X.XXX", "XX.XX", "XXX.X"...]
    */
    public List<String> ambiguousCoordinates(String s) {
        s=s.substring(1,s.length()-1);
        int n=s.length();
        List<String> result=new ArrayList<>();
        // s contains "(" and ")"
        for(int i=1;i<n;i++){
            List<String> leftCoordinates=findValidCoordinate(s.substring(0,i));
            if(leftCoordinates.size()==0) continue;
            List<String> rightCoordinates=findValidCoordinate(s.substring(i));
            if(rightCoordinates.size()==0) continue;
            for(String left :  leftCoordinates){
                for(String right :  rightCoordinates){
                    result.add("("+left+", "+right+")");
                }
            }
        }
         return result;
    }
    public List<String> findValidCoordinate(String sub){
        int n=sub.length();
        List<String> result=new ArrayList<>();
        if(n==0) return result; //if S == "": return []
        if(n==1 && sub.charAt(0)=='0') {
            result.add(sub); // if S == "0": return [S]
            return result;
        }
        //if S == "0XXX0": return []
        if(n>1 && sub.charAt(0)=='0' && sub.charAt(n-1)=='0') return result;
        if(n>1 && sub.charAt(0)=='0'){
            result.add("0."+sub.substring(1)); // return [S, "X.XXX", "XX.XX", "XXX.X"...]
            return result;
        }
        result.add(sub);
        if(sub.charAt(n-1)=='0') return result; // if S == "XXX0": return [S]
        for(int i=1;i<n;i++){ // return [S, "X.XXX", "XX.XX", "XXX.X"...]
           result.add(sub.substring(0,i)+"."+sub.substring(i)); 
        }
        return result;
    }
}
