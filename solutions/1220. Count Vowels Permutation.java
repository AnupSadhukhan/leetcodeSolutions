         //long count=0;
         int mod=1000000007;
         long aCountNew=0,uCountNew=0,eCountNew=0,iCountNew=0,oCountNew=0;
         for(int i=1;i<n;i++){
             aCountNew=(eCount + iCount + uCount) %mod;
             eCountNew = (aCount + iCount) % mod;
             iCountNew = (eCount + oCount) % mod;
             oCountNew = iCount %mod;
             uCountNew = (iCount + oCount) % mod;
             
             aCount = aCountNew;
             eCount = eCountNew;
             iCount = iCountNew;
             oCount = oCountNew;
             uCount = uCountNew;
             
             
         }
         long result = (aCount + eCount + iCount + oCount + uCount)%mod;
         return (int) result;
         
         
     }
    
}
​
