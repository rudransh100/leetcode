class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int [] res = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
        while(!st.isEmpty()&&nums2[i]>=st.peek()){
            st.pop();
        }
        if(st.isEmpty()){
            mpp.put(nums2[i],-1);
        }else{
            mpp.put(nums2[i],st.peek());
        }
        st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            res[i]=mpp.get(nums1[i]);
        }
        return res;
    }
}