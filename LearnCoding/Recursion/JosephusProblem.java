//Problem: https://practice.geeksforgeeks.org/problems/josephus-problem/1

public class JosephusProblem {
 
    public int josephus(int n, int k)
    {
        // Time Complexity for both solutions: O(n)

        //return josephusUtil(n,k) + 1;
        
        //Iterative solution
        int sum = 0;
        for(int i=2; i<=n; i++) {
            sum = (sum+k)%i;
        }
        return sum+1;
        
    }

   public int josephusUtil(int n, int k)
    {
        if(n == 1) {
            return 0;
        }
        return (josephusUtil(n-1,k) + k)%n;
    }
}
