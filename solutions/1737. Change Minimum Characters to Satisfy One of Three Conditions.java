class Solution {
   public  int minCharacters(String a, String b) {
            int[] arr1=new int[26];
            int[] arr2=new int[26];
            
            for(char c : a.toCharArray()){
                arr1[c-'a']++;
            }
            for(char c : b.toCharArray()){
                arr2[c-'a']++;
            }
            int n=a.length();
            int m=b.length();
            int res=m+n;
            
            for(int i=0;i<26;i++){
                res=Math.min(res,n-arr1[i]+m-arr2[i]);
                if(i>0){
                arr1[i]+=arr1[i-1];
                arr2[i]+=arr2[i-1];
                }
                
            }
            //System.out.println("eq "+res);
            res=Math.min(res,get(arr1,arr2,n));
            res=Math.min(res,get(arr2,arr1,m));
            return res;
            
        }
        //a<b
        public  int get(int countA[],int[] countB,int n){
            int min=Integer.MAX_VALUE;
            
            for(int i=1;i<26;i++){
               
                min=Math.min(min,n-countA[i-1]+countB[i-1]);
            }
            //System.out.println("get "+min);
            return min;
        }
​
}
​
