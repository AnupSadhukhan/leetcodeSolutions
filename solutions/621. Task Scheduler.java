class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        if(n==0 || tasks.length==1) return tasks.length;
       // System.out.println("test case");
        int[] map=new int[26];
        int maxFreq=0;
        int numOfMaxFreq=0;
        for(char c : tasks){
            map[c-'A']++;
            if(maxFreq==map[c-'A'])
            {
                numOfMaxFreq++;
            }     
            else if(maxFreq<map[c-'A']){
                maxFreq=map[c-'A'];
                numOfMaxFreq=1;
            }   
            
        }
        //e.g. A A A B B B C C
        // A-3, B-3, C-2 | n=2
        // A B _ A B _ A B 
        // n=1
        // A B A B A B => I can fill others alway inside these as it it already maintaining n
        // A B C A B C A B
        int blockSizeToArrangeMax = (maxFreq-1);
        int availableSlotsPerBlock = n-(numOfMaxFreq-1);
        int totalAvailableSlotsToFill = availableSlotsPerBlock * blockSizeToArrangeMax;
        int taskToDo = tasks.length - (maxFreq * numOfMaxFreq);
        int idles =  Math.max(0,totalAvailableSlotsToFill - taskToDo);
        
        return tasks.length + idles;
        
        
    }
  
}
