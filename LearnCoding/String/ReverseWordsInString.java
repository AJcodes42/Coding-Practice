//Problem: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        String words[] = S.split("\\.");
        StringBuffer sb = new StringBuffer();
        for(int i=words.length-1; i>0; i--) {
            sb.append(words[i]).append(".");
        }
        sb.append(words[0]);
        
        return sb.toString();
    }
}