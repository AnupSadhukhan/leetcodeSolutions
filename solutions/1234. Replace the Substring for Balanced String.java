                r--;
            }
            else if(arr[i]=='W'){
                w--;
            }
            else if(arr[i]=='E'){
                e--;
            }
            while(left<=i && q<=k && r<=k && w<=k && e<=k){
                min=Math.min(min,i-left+1);
                 if(arr[left]=='Q'){
                    q++;
                }
                else if(arr[left]=='R'){
                    r++;
                }
                else if(arr[left]=='W'){
                    w++;
                }
                else if(arr[left]=='E'){
                    e++;
                }
                left++;
            }
            
            
        }
        return min;
    }
    /*
      private boolean fulfilled(int[] freq) {
        boolean fulfilled = true;
        for(int f: freq) {
            if(f > 0) {
                System.out.println("not fulfilled!!");
                fulfilled = false;
            }
        }
        return fulfilled;
    }
    
     // Q 0 W 1 E 2 R 3
    private int charToIdx(char c) {
        switch(c) {
            case 'Q': return 0;
            case 'W': return 1;
            case 'E': return 2;
        }
        return 3;
    }
    
    public int balancedString(String s) {
        // 1) Find freq of each first
        int N = s.length();
        int required = N/4;
       
        int[] freq = new int[4];
        for(int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            ++freq[charToIdx(c)];
        }
        
        // 2) Determine the ones we need to change
        boolean equal = true;
        for(int i = 0; i < 4; ++i) {
            if(freq[i] != required) equal = false;
            freq[i] = Math.max(0, freq[i] - required);
        }
        
        if(equal) return 0; // Early return if all are equal
        
