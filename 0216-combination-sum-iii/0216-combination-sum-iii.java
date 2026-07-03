class Solution {
    void backtrack(int start,int k, int sum, List<List<Integer>> res, List<Integer> ds ){
        if(sum == 0 && k==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(k==0 && sum< 0)return;
        for(int i =start  ; i<=9 ; i++){
            if(k>0&&i<=sum){
                ds.add(i);
                backtrack(i+1,k-1,sum-i,res,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1,k,n,res,new ArrayList<>());
        return res;
    }
}