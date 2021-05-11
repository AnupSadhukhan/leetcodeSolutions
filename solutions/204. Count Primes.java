class Solution {
    // we can use normal sqrt function to check prime, that would take O(n*sqrt(n))
    // but it will give TLE, so we will use sieve of eratosthenes algorithms
    // O(nloglogn)
    public int countPrimes(int n) {
        int count=0;
        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<n;i++){
            if(!isPrime[i]) continue;
            for(int j=i*i;j<n;j+=i){
                isPrime[j]=false;
            }
        }
        
        for(int i=2;i<n;i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
   
}
