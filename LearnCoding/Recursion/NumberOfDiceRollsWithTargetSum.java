//Problem: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/

//My Solution:
class Solution {
    public int numRollsToTarget(int n, int k, int target) {

        int dp[][] = new int[n+1][target+1];
        // for(int i=0; i<=n; i++) {
        //     for(int j=0; j<=k; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return numRollsToTargetUtil(n,k,target,dp);
    }

    public int numRollsToTargetUtil(int n, int k, int target, int dp[][]) {

        if(target == 0 && n==0) {
            return 1;
        }
        if(n==0 || target == 0) {
            return 0;
        }

        if(dp[n][target] != -1) {
            return dp[n][target];
        }

        int count = 0;
        for(int i=1; i<=k && i<=target; i++) {
            count += numRollsToTargetUtil(n-1,k,target-i,dp);
            count %= 1000000007;
        }

        dp[n][target] = count;
        return count;
    }
}


//Other Solutions


//Approach 1: Recursion
//Time Complexity = O(k ^ n)
//Space Complexity = O(n)
class Solution {
    private final int mod = (int) 1e9 + 7;
    
    public int numRollsToTarget(int n, int k, int target) {
        return getCountOfWaysWithTargetSum(n, k, target);
    }
    
    private int getCountOfWaysWithTargetSum(int n, int k, int target) {
        if (target < 0) {
            return 0;
        }
        
        if (n == 0) {
            return (target == 0) ? 1 : 0;
        }
        
        int count = 0;
        
        for (int i = 1; i <= k; i++) {
            count = (count + getCountOfWaysWithTargetSum(n - 1, k, target - i)) % mod;
        }
        
        return count;
    }
}


//Approach 2: Memoization (DP)
//Time Complexity = O(n * k * target)
//Space Complexity = O(n * target)
class Solution {
    private final int mod = (int) 1e9 + 7;
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return getCountOfWaysWithTargetSum(n, k, dp, target);
    }
    
    private int getCountOfWaysWithTargetSum(int n, int k, int[][] dp, int target) {
        if (target < 0) {
            return 0;
        }
        
        if (n == 0) {
            return (target == 0) ? 1 : 0;
        }
        
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        
        int count = 0;
        
        for (int i = 1; i <= k; i++) {
            count = (count + getCountOfWaysWithTargetSum(n - 1, k, dp, target - i)) % mod;
        }
        
        return dp[n][target] = count;
    }
}


//Appraoch 3: Tabulation (DP)
//Time Complexity = O(n * k * target)
//Space Complexity = O(n * target)
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][target + 1];
        
        dp[0][0] = 1;
        
        for (int dice = 1; dice <= n; dice++) {
            for (int tar = 1; tar <= target; tar++) {
                for (int i = 1; i <= k; i++) {
                    if (tar - i >= 0) {
                        dp[dice][tar] = (dp[dice][tar] + dp[dice - 1][tar - i]) % mod;
                    }
                }
            }
        }
        
        return dp[n][target];
    }
}