class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = 1;
        for(int i =1 ;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }else if (nums[i]<min){
                min = nums[i];
            }
        }
        for(int i = 1;i<= max;i++){
            if(min%i==0 && max%i==0){
                res = i;
            }
        }
        return res;
    }
}