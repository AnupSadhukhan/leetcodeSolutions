class Solution {
    // approch 1: using lastIndexOf method of the char, we need to put all same char in one part
    // only, so, when last index and i is same means, it ends here, else we can continue to include
    // the char in the same string
    
    // approch 2: uses same concept, here we keep last index in the array of size 26,
    // we iterate the char array and update last char position int the last index array
    public List<Integer> partitionLabels(String s) {
        // 9 ms
        /*int last=-1;
        int maxPart=0;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int part=s.lastIndexOf(s.charAt(i));
            maxPart=Math.max(maxPart,part);
            
            if(maxPart==i)
            {
                result.add(part-last);
                last=i;
            }
        }
        return result;*/
        //2 ms
        int[] lastIndex=new int[26];
        char[] chs=s.toCharArray();
        for(int i=0;i<chs.length;i++){
            // update last index for that alphabets
            lastIndex[chs[i]-'a']=i; 
        }
        int start=-1;
        int furthest=0;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<chs.length;i++){
            furthest=Math.max(furthest,lastIndex[chs[i]-'a']);
            if(furthest==i){
                result.add(i-start);
                start=i;
            }
        }
        return result;
    }
}
