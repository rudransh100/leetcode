class Solution {
    void combination(String digits,String curr,int ind,List<String> res,String[] map){
        if(ind == digits.length()){
            res.add(curr);
            return;
        }
        String s = map[digits.charAt(ind) - '0'];
        for(int i =0 ;i<s.length();i++){
            combination(digits,curr+s.charAt(i),ind+1,res,map);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs", "tuv","wxyz"};
        combination(digits,"",0,res,map);
        return res;
    }
}