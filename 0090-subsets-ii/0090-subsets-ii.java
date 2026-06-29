class Solution {
    void power_set(int[] arr,int index,Set<List<Integer>> res,List<Integer> ds){
        if(index == arr.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[index]);
        power_set(arr,index+1,res,ds);
        ds.remove(ds.size()-1);
        power_set(arr,index+1,res,ds);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        power_set(nums, 0, res, new ArrayList<>());
        return new ArrayList<>(res);
    }
}