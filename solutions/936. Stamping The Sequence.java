class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] s=stamp.toCharArray();
        char[] t=target.toCharArray();
        int replaced=0;
        boolean[] vis=new boolean[t.length];
        List<Integer> li=new ArrayList<Integer>();
        while(replaced<t.length){
            boolean targetFound=false;
            for(int i=0;i<=t.length-s.length;i++){
                if(!vis[i] && canReplace(s,t,i)){
                    vis[i]=true;
                    targetFound=true;
                    replaced+=replace(t,i,s.length);
                   // System.out.println("can replace? Yes ");
                   // System.out.println("replaced  "+replaced);
                    li.add(i);
                    if(replaced==t.length){
                        break;
                    } 
                    
                }
                
            }
            if(!targetFound) return new int[0];
            
        }
       int[] res=new int[li.size()];
        for(int i=0;i<li.size();i++){
            res[i]=li.get(li.size()-i-1);
        }
        return res;
        
    }
    public boolean canReplace(char[] s,char[] t,int start){
        //System.out.println("called at "+start);
        for(int i=0;i<s.length;i++){
            if(t[i+start]!='*' && t[i+start]!=s[i]) return false;
        }
        return true;
    }
    public int replace(char[] t,int start,int len){
       // System.out.println("replace called at "+start);
        int count=0;
        for(int i=0;i<len;i++){
            if(t[i+start]!='*'){
                t[i+start]='*';
                count++;
            }
        }
       // System.out.println("count : "+count);
        return count;
