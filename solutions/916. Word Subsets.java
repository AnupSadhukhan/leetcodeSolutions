class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        if(A.length==0 || B.length==0) return null;
        int[] arr=new int[26];
        int[] arr3;
        for(String b : B){
            arr3=new int[26];
            for(char c : b.toCharArray())
                arr3[c-'a']++;
            for(int i=0;i<26;i++){
                arr[i]=Math.max(arr[i],arr3[i]);
            }
        }
        List<String> res=new ArrayList<String>();
        int[] arr1;
        boolean include=true;
        for(String a : A){
            include=true;
            arr1=new int[26];
            //System.out.println("word "+a);
            for(char c : a.toCharArray())
                arr1[c-'a']++;
            for(int i=0;i<26;i++){
                if(arr[i]>arr1[i]){
                   // System.out.println("not matched!");
                    include=false;
                    break;
                }
            }
            if(include){
                res.add(a);
            }
        }
        return res;
    }
}
