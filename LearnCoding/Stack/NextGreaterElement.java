//Problem: https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> stc = new Stack<Long>();
        
        long ans[] = new long[n];
        Arrays.fill(ans,-1l);
        int i=n-1;
        while(i>=0) {
            while(!stc.isEmpty() && stc.peek()<=arr[i]) {
                stc.pop();
            }
            if(stc.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stc.peek();
            }
            stc.push(arr[i]);
            i--;
        }
        
        return ans;
    } 
}