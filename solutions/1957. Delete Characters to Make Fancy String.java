class Solution {
    public String makeFancyString(String s) {
        if(s.length()<3) return s;
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        int i = 2;
        while(i<s.length()){
            char c = s.charAt(i);
            i++;
            int lastIndex = sb.length()-1;
           // System.out.println(sb.toString()+"- "+c+" : "+sb.charAt(lastIndex-1)+", "+sb.charAt(lastIndex-2));
            if(sb.charAt(lastIndex)==c && sb.charAt(lastIndex-1)==c){
                
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
        
    }
}
