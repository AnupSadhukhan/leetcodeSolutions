class Solution {
    /*  start from starting lock sequsnce, then try to generate all
    possible locks that can be reached from current lock sequence both from
    forward and backward side.
    we will push generated locks in queue as we are using bfs, then we will poll one 
    by one ,if it is not deadends, we will again generate all possible locks from cur
    seq and do the same steps agains, with that also increase level everytime. if 
    at any point we get target result then return level value.
    */    
    private static final String START = "0000";
    
    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) return -1;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer(START);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentLock = queue.poll();
                if (!visited.add(currentLock)) continue;
                if (currentLock.equals(target)) return level;
                
                for (String nextLock : getNextStates(currentLock)) {
                    if (!visited.contains(nextLock)) queue.offer(nextLock);
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
}
