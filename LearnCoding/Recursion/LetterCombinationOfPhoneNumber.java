//Solution: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {
    public static String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();

        letterCombinationsUtil("",digits,list);
        return list;
    }

    public void letterCombinationsUtil(String processedString,String digits, ArrayList<String> list) {
        if(digits.length() == 0) {
            if(processedString.length() != 0) {
                list.add(processedString);
            }
            return;
        }
        String chars = KEYS[digits.charAt(0)-'0'];
        for(int i=0; i<chars.length(); i++) {
            letterCombinationsUtil(processedString+chars.charAt(i),digits.substring(1),list);
        }
    }
}
