class Solution {
    String normalizeString(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c!='#'){
                sb.append(c);
            }
            else{
                if(!sb.isEmpty()){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        return normalizeString(s).equals(normalizeString(t));
    }
}