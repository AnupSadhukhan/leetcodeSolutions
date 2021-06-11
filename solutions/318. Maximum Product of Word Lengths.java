class Solution {
    // Approch 1: for each word create a boolean array of size 26 and map
    // charters to index if a particular index is false in the array make it true
    // as char appeared for in that word, do the same and store int a list
    // now run outer loop which will run upto n-1 and inner loop will run upto n
    // for each word we will take all other words right side of that words
    // because left side combination already done. and we will compare boolean 
    // array both words, if none of the char match calculate the result and put
    // max result in max, else continue. at the end return the result.
    
    // approch 2: is based on approch 1 , however we are using bit manipulation,
    // we take a array of int, which will hold the value of OR-ed index
    //  index= of the char (char -'0') then value|=1<<index
    // we will run two loop again and do AND-ed of two word's value, if it
    // is zero that means there were no common char else there was
    // if there were no comon chars, we will calculate result each time and return
    // max of the result else return 0;
    public int maxProduct(String[] words) {
       
        int n=words.length;
        int max=0;
         // 25 ms
          /*
        List<boolean[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
           
            boolean[] arr=new boolean[26];
            int count=0;
            int j=0;
            char[] chs=words[i].toCharArray();
            while(count!=26 && j<chs.length){
                if(!arr[chs[j]-'a']){
                    arr[chs[j]-'a']=true;
                    count++;
                }
                j++;
             }
             list.add(arr);
        }
        for(int i=0;i<words.length-1;i++){
          
            boolean[] arr1=list.get(i);
            int len1=words[i].length();
            for(int j=i+1;j<n;j++){
                boolean arr2[]=list.get(j);
                boolean flag=false;
                int len2=words[j].length();
                for(int k=0;k<26;k++){
                    if(arr1[k] && arr2[k]){
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    max=Math.max(max,len1*len2);
                }
            }
        }
        return max;*/
        // using bit manipulation
        int[] values=new int[n];
        for(int i=0;i<n;i++){
            int value=0;
            for(char c :  words[i].toCharArray()){
                value |= 1<<(c-'a');
            }
            values[i]=value;
        }
        for(int i=0;i<n-1;i++){
            int len1=words[i].length();
            for(int j=i+1;j<n;j++){
                int len2=words[j].length();
                if((values[i] & values[j])==0){
                   
                    max=Math.max(max,len1*len2);
                    
                }
            }
        }
        return max;
    }
}
