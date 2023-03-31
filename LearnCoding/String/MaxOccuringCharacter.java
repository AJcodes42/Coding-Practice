//Problem:  https://practice.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1

class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        int count[] = new int[256];
        int index = -1;
        int max = -1;
        
        for(int i=0;i<line.length(); i++) {
            count[line.charAt(i)] +=1;
        }
        
        for(int i=0; i<line.length(); i++) {
            if(count[line.charAt(i)] > max) {
                index = i;
                max = count[line.charAt(i)];
            } else if(count[line.charAt(i)] == max) {
                if(line.charAt(i)<line.charAt(index)) {
                    index = i;
                }
            }
        }
        
        return line.charAt(index);
    }
    
}