//Problem: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> stc = new Stack<>();
        int ans[] = new int[n];
        
        int i=0;
        while(i<n) {
            while(!stc.isEmpty() && price[stc.peek()]<=price[i]) {
                stc.pop();
            }
            if(stc.isEmpty()) {
                ans[i]= i+1;
            } else if(price[stc.peek()]>price[i]) {
                ans[i] = i-stc.peek();
            }
            stc.push(i);
            i++;
            
        }
        
        return ans;
    }
    
}