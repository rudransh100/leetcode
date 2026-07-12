class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int rank = 1;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i : temp){
            if(!mpp.containsKey(i)){
                mpp.put(i,rank++);
            }
        }
        for(int i =0 ;i<arr.length;i++){
            arr[i]=mpp.get(arr[i]);
        }
        return arr;
    }
}