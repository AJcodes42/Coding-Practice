// Problem: https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean visited[][] = new boolean[n][n];
        
        for(boolean[] arr : visited) {
            Arrays.fill(arr,false);    
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        nQueenUtil(n,0,ans,visited);
        return ans;
        
    }
    
    static void nQueenUtil(int n,int col, ArrayList<ArrayList<Integer>> ans, boolean visited[][]) {
        if(col == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0;j<n;j++) {
                    if(visited[j][i]) {
                        list.add(j+1);
                    }
                }
            }
            ans.add(list);
            return;
        }
        for(int i=0; i<n;i++) {
            if(isSafe(i,col,n,visited)) {
                //System.out.println("visiting "+i+" "+col);
                visited[i][col] = true;
                nQueenUtil(n,col+1,ans,visited);
                visited[i][col] = false;
            }
        }
    }
    
    static boolean isSafe(int row, int col, int n,boolean visited[][]) {
        for(int i=0; i<col; i++) {
            //System.out.println("checking visited "+row+" "+col+" "+ visited[row][col]);
            if(visited[row][i]) {
                //System.out.println("returning false "+row+" "+col);
                return false;
            }
        }
        
        int minDiagonalUp = Math.min(row,col);
        int minDiagonalDown = Math.min(col,n-row-1);
        
        for(int i=0;i<minDiagonalUp;i++) {
            if(visited[row-i-1][col-i-1]) {
                return false;
            }
        }
        
        for(int i=0;i<minDiagonalDown;i++) {
            if(visited[row+i+1][col-i-1]) {
                return false;
            }
        }
        //System.out.println("returning true "+row+" "+col);
        return true;
        
    }
    
}