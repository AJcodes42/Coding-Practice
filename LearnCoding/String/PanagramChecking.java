//Problem: https://practice.geeksforgeeks.org/problems/pangram-checking-1587115620/1

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String str) {
        boolean chars[] = new boolean[26];
        
        for(int i=0; i<str.length();i++) {
            if(str.charAt(i)>='a' && str.charAt(i)<='z') {
                chars[str.charAt(i) - 'a'] = true;
            } else if (str.charAt(i)>='A' && str.charAt(i)<='Z') {
                chars[str.charAt(i) - 'A'] = true;
            } else continue;
        }
        
        /**
         * To check the first missing character
         **/ 
         
        // String result = "";
        // for(int i=0; i<26; i++) {
        //     if(!chars[i]) {
        //         result += (char)(i+'a');
        //     }
        // }
        // System.out.println(result);
        
        for(boolean letterPresent : chars) {
            if(!letterPresent) {
                return false;
            }
        }
        
        
        return true;
    }