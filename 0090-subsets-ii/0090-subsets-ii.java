class Solution {
    void power_set(int[] arr,int index,List<List<Integer>> res,List<Integer> ds){
        res.add(new ArrayList<>(ds));
        for(int i = index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])continue;
            ds.add(arr[i]);
            power_set(arr,i+1,res,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        power_set(nums, 0, res, new ArrayList<>());
        return res;
    }
}