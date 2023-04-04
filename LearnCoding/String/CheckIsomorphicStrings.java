//Problem: https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1

class Solution
{
    // Time Complexity: O(N), traversing over the string of size N.
    // Auxiliary Space: O(1) 
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length()) {
            return false;
        }
        
        HashMap<Character,Character> hmap = new HashMap<>();
        char c = 'a';
        for(int i=0; i<str1.length(); i++) {
            if(hmap.containsKey(str1.charAt(i))) {
                c = hmap.get(str1.charAt(i));
                if(c != str2.charAt(i)) {
                    return false;
                }
            } else if(hmap.containsValue(str2.charAt(i))) {
                return false;
            } else {
                hmap.put(str1.charAt(i),str2.charAt(i));
            }
        }
        
        return true;
    }
}