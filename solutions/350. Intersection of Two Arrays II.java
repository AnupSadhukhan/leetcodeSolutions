class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash=new int[1001];
        for(int elm : nums1){
            hash[elm]++;
        }
        List<Integer> list=new ArrayList<>();
        for(int elm :  nums2){
            if(hash[elm]>0){
                hash[elm]--;
                list.add(elm);
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
