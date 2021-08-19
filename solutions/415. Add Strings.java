class Solution {
    public String addStrings(String num1, String num2) {
        String tmp="";
        if(num1.length()<num2.length()) {
            tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int index = chs1.length-1;
        for(int i=chs2.length-1;i>=0 && index>=0;i--,index--){
            int a = chs1[index]-'0';
            int b = chs2[i]-'0';
            char c = (char) (((a+b+carry)%10)+'0');
            carry = (a+b+carry)/10;
            //System.out.println(chs1[index]+" - "+chs2[i] + " : "+c+" , carry"+carry+" sum "+(a+b+carry));
            sb.insert(0,c);
        }
        for(int i = index; i>=0;i--){
            int a = chs1[i]-'0';
            char c = (char) ((a+carry)%10 + '0');
            carry = (a+carry)/10;
            sb.insert(0,c);
        }
        if(carry!=0){
            char c =(char) (carry + '0');
            sb.insert(0,c);
        }
        return sb.toString();
    }
}
