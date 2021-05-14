class Solution {
    //O(n.(n+2^n+2^n)) = O(n.2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> partitionList=new ArrayList<List<String>>();
        if(s==null || s.length()==0) return partitionList;
        if(s.length()==1) {
            List<String> list=new ArrayList<>();
            list.add(s);
            partitionList.add(list);
            return partitionList;
        }
        int n=s.length();
        //O(n)
        for(int i=0;i<n;i++){
            
            String subStr=s.substring(0,i+1);
            //O(n)
            if(!isPalindrome(subStr)) continue;
            if(i+1==n) {
                List<String> list=new ArrayList<>();
                list.add(subStr);
                partitionList.add(list);
                continue;
            }
            //System.out.println("for...");
            //O(2^n)
            List<List<String>> nextStringPartitionList=partition(s.substring(i+1));
            //O(2^n)
            for(List<String> part :  nextStringPartitionList){
                List<String> list=new ArrayList<>();
                list.add(subStr);
                list.addAll(part);
                partitionList.add(list);
            }
            
        }
        return partitionList;
    }
    public boolean isPalindrome(String s){
        if(s==null || s.length()==0) return false;
        if(s.length()==1) return true;
        int left=0,right=s.length()-1;
        while(left<right){
            //System.out.println("while...");
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
}
