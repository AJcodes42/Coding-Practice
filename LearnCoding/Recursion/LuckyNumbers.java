//Problem: https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1

class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        return isLuckyUtil(n,2);
    }

    public static boolean isLuckyUtil(int n,int counter)
    {
        if(n%counter == 0) {
            return false;
        }
        if(n<counter) {
            return true;
        }

        n = n-n/counter;

        return isLuckyUtil(n, counter+1);
    }

    
}
