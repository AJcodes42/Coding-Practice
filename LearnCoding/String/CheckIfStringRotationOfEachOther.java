//Problem: https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1

class Solution
{
    //Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2 )
    {
        // for(int i=0; i<s1.length(); i++) {             // n times as there are n-1 partitions
        //     String firstSub = s1.substring(0,i);
        //     String secondSub = s1.substring(i,s1.length());
        //     String rotatedString = secondSub + firstSub;
        //     if(rotatedString.equals(s2)) {               // comparing two string takes O(n) complexity as comparison happens in linear time
        //         return true;
        //     }
        // }
        
        // So total time complexity of above solution is O(n^2)
        
        // Time complexity of below is O(n) as it is normal pattern search with kmp algo
        return (s1.length() == s2.length()) && 
              ((s1 + s1).indexOf(s2) != -1);
        
        // return false;
    }
    
}