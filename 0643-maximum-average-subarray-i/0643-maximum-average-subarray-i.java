class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double[] prefix = new double[nums.length-k+1];
        double sum =0;
        if(nums.length==1){
            return (double)nums[0];
        }
        for (int i= 0 ;i<k;i++){
            sum+=nums[i];
        }
        prefix [0]=sum;
        double max = prefix[0];
        for(int i= 1;i< prefix.length;i++){
            prefix[i] = prefix[i-1]-nums[i-1]+nums[k+i-1];
            max = Math.max(max,prefix[i]);
        }
        return max/k;
    }
}