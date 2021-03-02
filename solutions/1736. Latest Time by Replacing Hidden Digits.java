class Solution {
    public String maximumTime(String time) {
        char[] times=time.toCharArray();
        times[0]=times[0]=='?'? times[1]=='?' || times[1]<'4'? '2' :'1' :times[0];
        times[1]=times[1]=='?' && times[0]=='2'? '3' : times[1]=='?' ? '9' : times[1];
        times[3]=times[3]=='?' ? '5' : times[3];
        times[4]=times[4]=='?' ? '9' : times[4];
        return new String(times);
        
    }
}
