class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(sb.isEmpty()|| c!= sb.charAt(sb.length()-1)){
                sb.append(c);
            }
            else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}