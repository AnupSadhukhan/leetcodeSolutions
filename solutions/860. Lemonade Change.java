class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length==0 || bills[0]!=5) return false;
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                ten++;
                if(five==0) return false;
                five--;
            }
            else{
                 int change=15;
                if(ten>0){
                    ten--;
                    change=5;
                }
                if(5*five<change) return false;
                five-=(change/5);
               
            }
           
        }
        return true;
    }
}
