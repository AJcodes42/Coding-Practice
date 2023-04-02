//Problem : https://practice.geeksforgeeks.org/problems/remainder-with-7/1


class Solution
{
    // Complete the function
    int remainderWith7(String num)
    {
        int rem = 0;
        
        for(int i=0; i<num.length(); i++) {
            rem = rem*10 + (num.charAt(i)-'0');
            rem %= 7;
        }
        return rem;
    }
}