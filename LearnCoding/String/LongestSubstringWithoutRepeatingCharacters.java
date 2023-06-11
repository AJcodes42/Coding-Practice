//Problem: https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1

class Solution{
    int longestUniqueSubsttr(String S){
        
        //Solution 1
        // Time Complexity: O(n)  Space Complexity: O(1)
        // boolean visited[] = new boolean[256];
        // Arrays.fill(visited,false);
        // int start = 0, end = 0, maxLength = 0;

        // while(start<S.length() && end<S.length()) {
        //     if(visited[S.charAt(i)]) {
        //         visited[S.charAt(start)] = false;
        //         start++;
        //     } else {
        //         visited[S.charAt(i)] = true;
        //         maxLength = Math.max(maxLength, end-start+1);
        //         end++;
        //     }
        // }
        // return maxLength;


        //Solution 2
        // Little bit optimised than solution 1 as we are storing the index at which
        // character occured
        // Time Complexity: O(n)  Space Complexity: O(1)
        int visited[] = new int[256];
        Arrays.fill(visited,-1);
        int start = 0, end = 0, maxLength = 0;

        for(;end<S.length(); end++) {
            if(visited[S.charAt(end)] != -1 && visited[S.charAt(end)]>=start) { // notice condition 2
                start = visited[S.charAt(end)]+1;
                visited[S.charAt(end)] = end;
                maxLength = Math.max(end-start+1, maxLength);
            } else {
                visited[S.charAt(end)] = end;
                maxLength = Math.max(end-start+1, maxLength);
            }
        }

        return maxLength;
    }
}
