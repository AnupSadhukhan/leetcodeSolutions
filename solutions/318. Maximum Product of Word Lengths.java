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
