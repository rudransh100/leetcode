class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            st.push(i);
            int j = (i+1)%n;
            while(!st.isEmpty() && j!=i){
                if(nums[st.peek()]<nums[j]){
                    int index = st.pop();
                    res[index] = nums[j];
                    break;
                }else {
                    j = (j+1)%n;
                }
            }
            if(j==i){
                res[i] = -1;
            }
        }
        return res;
    }
}