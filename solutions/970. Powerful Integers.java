class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int x1=1;
        int y1=1;
        //List<Integer> res=new ArrayList<>();
       
        Set<Integer> set=new HashSet<>();
         if(x==1 && y==1 && bound>=2){
             set.add(2);
            
        }
        if(x==1){
            int tmp=y;
            y=x;
            x=tmp;
        }
        while(x1+y1<=bound && x!=1){
            y1=1;
            while(x1+y1<=bound && y!=1){
                set.add(x1+y1);
                y1*=y;
            }
            if(y==1 && x1+y<=bound){
                set.add(x1+y);
            }
            y1=1;
            x1*=x;
        }
        return new ArrayList<>(set);
    }
}
