class Solution {
    void findCombination (int index,int[] arr,int target,List<List<Integer>> res, List<Integer> ds){
        if(index == arr.length ){
            if(target ==0){
                res.add(new ArrayList<>(ds));    
            }
            return;
        }
        if(arr[index]<=target){
            ds.add(arr[index]);
            findCombination(index,arr,target-arr[index],res,ds);
            ds.remove(ds.size()-1);

        }
        findCombination(index+1,arr,target,res,ds);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombination (0,candidates,target,res,new ArrayList<>());
        return res;


    }
}