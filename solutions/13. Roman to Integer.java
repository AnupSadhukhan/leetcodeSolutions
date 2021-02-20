class Solution {
    public int romanToInt(String s1) {
        /* Approch 1 */
       /* HashMap<String,Integer> map=new HashMap<String,Integer>();
        String[] roman={"I-1","V-5","X-10","L-50","C-100","D-500","M-1000"};
        for(String s : roman){
            String[] str=s.split("-");
            map.put(str[0],Integer.parseInt(str[1]));
        }
        char[] c=s1.toCharArray();
        int num=0;
        for(int i=c.length-1;i>=0;i--){
            if(c[i]=='I' && i<c.length-1 && (c[i+1]=='V' ||c[i+1]=='X') ){
                num-=1;
            }
            else if(c[i]=='X' && i<c.length-1 && (c[i+1]=='L' ||c[i+1]=='C')){
                num-=10;
            }
            else if(c[i]=='C' && i<c.length-1 && (c[i+1]=='D' ||c[i+1]=='M')){
                num-=100;
            }
            else{
                num+=map.get(c[i]+"");
                //System.out.println("i "+i+" num "+num);
            }
        }
        return num;
        */
        int num=0;
        char[] c = s1.toCharArray();
        int val=0;
        for(int i=c.length-1;i>=0;i--){
            val=charToInt(c[i]);
            if(i<c.length-1 && val<charToInt(c[i+1])){
                num-=val;
            }
            else num+=charToInt(c[i]);
        }
        return num;
    }
    public int charToInt(char c){
        switch(c){
        case 'I' : return 1;
        case 'V' : return 5;
        case 'X' : return 10;
        case 'L' : return 50;
        case 'C' : return 100;
        case 'D' : return 500;
        case 'M' : return 1000; 
        }
        return 0;
       
    }
}
