class Solution {
    HashMap<Integer,Integer> cache=new HashMap<Integer,Integer>();
    public int fib(int n) {
        if(cache.get(n)!= null) return cache.get(n);
        if(n<2) return n;
        int result=fib(n-1)+fib(n-2);
        cache.put(n,result);
        return result;
    }
}
