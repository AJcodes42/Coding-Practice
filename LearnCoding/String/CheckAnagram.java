//Problem:  https://practice.geeksforgeeks.org/problems/anagram-1587115620/1

class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length()) {
            return false;
        }
        
        int charCountA[] = new int[26];
        int charCountB[] = new int[26];
        
        for(int i=0; i<a.length(); i++) {
            charCountA[a.charAt(i)-'a']++;
        }
        for(int i=0; i<b.length(); i++) {
            charCountB[b.charAt(i)-'a']++;
        }
        
        for(int i=0; i<26; i++) {
            if(charCountA[i] != charCountB[i]) {
                return false;
            }
        }
        
        return true;
        
    }
}