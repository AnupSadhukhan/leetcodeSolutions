class Solution {
    public int totalFruit(int[] tree) {
        int typeA=-1;
        int countA=0;
        int typeB=-2;
        int countB=0;
        int left=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<tree.length;i++){
            if(typeA==-1 || tree[i]==typeA){
                typeA=tree[i];
                countA++;
            }
            else if(typeB==-1 || tree[i]==typeB){
                typeB=tree[i];
                countB++;
            }
            else{
                while(left<=i && countA>0 && countB>0){
                    if(tree[left]==typeA){
                        countA--;
                    }
                    else if(tree[left]==typeB){
                        countB--;
                    }
                    left++;
                }
                if(countA==0){
                    countA++;
                    typeA=tree[i];
                }
                else{
                    countB++;
                    typeB=tree[i];
                }
            }
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}
