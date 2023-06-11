//https://practice.geeksforgeeks.org/problems/excel-sheet5448/1

class Solution {
    public String excelColumn(int N){
        
        //Solution 1
        StringBuilder sb = new StringBuilder("");
        while(N>0) {
            if(N%26 == 0) {
                sb.append('Z');
                N = N/26-1;
            } else {
                sb.append((char)((N%26-1) + 'A'));
                N=N/26;
            }
        }
        
        return sb.reverse().toString();
        
        
        // StringBuilder sb = new StringBuilder("");
        // //Solution 2
        // int n = N;
        // int maxLength = (int) (Math.log(n) / Math.log(26)) + 1;
        // int []arr = new int[maxLength];
        // int i = 0;
 
        // // Step 1: Converting to number
        // // assuming 0 in number system
        // while (n > 0)
        // {
        //     arr[i] = n % 26;
        //     n = n / 26;
        //     i++;
        // }
 
        // // Step 2: Getting rid of 0, as 0 is
        // // not part of number system
        // for(int j = 0; j < i - 1; j++)
        // {
        //     if (arr[j] <= 0)
        //     {
        //         arr[j] += 26;
        //         arr[j + 1] = arr[j + 1] - 1;
        //     }
        // }
 
        // for(int j = i-1; j >= 0; j--)
        // {
        //     if (arr[j] > 0)
        //         sb.append((char)(arr[j]-1+'A'));
        // }
        
        // return sb.toString();
        
        
    }
}
