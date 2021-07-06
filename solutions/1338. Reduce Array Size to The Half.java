class Solution {
    public int minSetSize(int[] arr) {
        int[] map=new int[1_00_001];
        for(int elm : arr){
            map[elm]++;
        }
        Arrays.sort(map);
        int new_length=arr.length;
        int original_length=arr.length;
        int index = 1_00_000;
        while(new_length>original_length/2){
            new_length-=map[index--];
        }
        return 1_00_000 - index ;
    }
}
