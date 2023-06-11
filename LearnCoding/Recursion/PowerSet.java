//Problem: https://practice.geeksforgeeks.org/problems/power-set4302/1

import java.util.List;

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        ArrayList<String> ans = new ArrayList<>();
        allPossibleStringsUtil("",s,ans);
        Collections.sort(ans);
        return ans;
    }
    
    public void allPossibleStringsUtil(String p, String up,List<String> ans) {
        if(up.length() == 0) {
            if(!p.isBlank()) {
             ans.add(p);
            }
            return;
        }

        char ch = up.charAt(0);

        allPossibleStringsUtil(p+ch,up.substring(1),ans);
        allPossibleStringsUtil(p,up.substring(1),ans);
    }
}
