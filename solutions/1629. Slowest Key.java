class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n=releaseTimes.length;
        int du[]=new int[n];
        du[0]=releaseTimes[0];
        int max=du[0];
        char c=keysPressed.charAt(0);
        for(int i=1;i<n;i++){
            du[i]=releaseTimes[i]-releaseTimes[i-1];
           
            if(du[i]>max){
                max=du[i];
                c=keysPressed.charAt(i);
            }
            else  if(max==du[i]){
                if (keysPressed.charAt(i) - 'a' > c - 'a') {
                    c = keysPressed.charAt(i);
                }
                //c = c>keysPressed.charAt(i)? c : keysPressed.charAt(i); 
            
            }
            
        }
        //System.out.println(max);
        
        return c; 
        /*char chosenLetter = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        
        for (int i = 1; i<releaseTimes.length;i++) {
            int currentReleaseTime = releaseTimes[i] - releaseTimes[i-1];
            if (currentReleaseTime > maxTime) {
                maxTime = currentReleaseTime;
                chosenLetter = keysPressed.charAt(i);
            } else if (currentReleaseTime == maxTime) {
                if (keysPressed.charAt(i) - 'a' > chosenLetter - 'a') {
                    chosenLetter = keysPressed.charAt(i);
                }
            }
        }
        return chosenLetter;*/
    }
}
