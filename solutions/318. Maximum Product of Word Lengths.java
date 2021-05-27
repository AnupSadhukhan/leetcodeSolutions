class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int max=0;
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
        return max;
    }
}
