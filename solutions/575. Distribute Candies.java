class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i : candyType){
            set.add(i);
        }
        return set.size()>candyType.length/2?candyType.length/2 : set.size();
    }
}
