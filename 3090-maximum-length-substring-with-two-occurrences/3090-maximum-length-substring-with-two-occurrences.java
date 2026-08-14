class Solution {
    public int maximumLengthSubstring(String s) {
        int max =0;
        for(int i = 0; i<s.length();i++){
            Map<Character,Integer> mpp = new HashMap<>();
            // mpp.put(s.charAt(i),1);
            int j=i;
            while(j<s.length() && i<=j ){
                if(!mpp.containsKey(s.charAt(j))){
                    mpp.put(s.charAt(j),1);
                    j++;
                }
                else if(mpp.containsKey(s.charAt(j))&&mpp.get(s.charAt(j))<2){
                    mpp.put(s.charAt(j),mpp.get(s.charAt(j))+1);
                    max = Math.max(max,j-i+1);
                    j++;
                }else{
                    break;
                }
                max = Math.max(max,j-i);
            }
        }
        return max;
    
    }
}