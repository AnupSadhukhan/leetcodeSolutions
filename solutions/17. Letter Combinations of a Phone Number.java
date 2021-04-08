class Solution {
    StringBuilder sb=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null || digits.equals("") || digits.equals("1")) return res;
       String[] map=new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       return combination(digits.toCharArray(),0,map,res);
    }
    public List<String> combination(char[] number,int idx,String[] map,List<String> res){
         if(number==null || number.length==0) {
             return res;
         }
         if(idx==number.length ){
             if(sb.length()!=0)res.add(sb.toString());
             return res;
         }
         for(char c : map[number[idx]-'0'].toCharArray()){
             sb.append(c);
             combination(number,idx+1,map,res);
             sb.deleteCharAt(sb.length()-1);
         }
        return res;
    }
    
}
