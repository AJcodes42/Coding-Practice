//Problem: https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1

class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        if(KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
            return 0;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(KnightPos);
        
        int steps = 0;int size = 0,newX = -1,newY = -1;
        int xPos[] = {-2,-2,2,2,1,-1,1,-1};
        int yPos[] = {1,-1,1,-1,2,2,-2,-2};
        boolean visited[][] = new boolean[N+1][N+1];
        for(boolean vis[] : visited) {
            Arrays.fill(vis,false);
        }
        visited[KnightPos[0]][KnightPos[1]] = true;
        while(!q.isEmpty()) {
            steps++;
            size = q.size();
            while(size-->0) {
                int curr[] = q.remove();
                for(int i=0;i<8; i++) {
                    newX = curr[0] + xPos[i];
                    newY = curr[1] + yPos[i];
                    
                    if(isSafe(newX,newY,N) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        if(newX == TargetPos[0] && newY == TargetPos[1]) {
                            return steps;
                        }
                        int ind[] = new int[2];
                        ind[0] = newX;
                        ind[1] = newY;
                        q.add(ind);
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean isSafe(int x, int y, int N) {
        if(x>0 && x<=N && y>0 && y<=N) {
            return true;
        }
        return false;
    }
}
