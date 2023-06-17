//Problem: https://practice.geeksforgeeks.org/problems/max-rectangle/1

class Solution {
    public int maxArea(int M[][], int n, int m) {
        int max = 0;
        int curr = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i>0 && M[i][j] == 1) {
                    M[i][j] += M[i-1][j];
                 }
            }
            // curr = maxHistogramArea(M[i],m);
            curr = optimisedMaxHistogramArea(M[i],m);
            max = Math.max(max,curr);
        }
        
        return max;
    }
    
    public int optimisedMaxHistogramArea(int M[], int m) {
        Stack<Integer> stc = new Stack<>();
        
        int i = 0,max = 0,area = 0,top;
        while(i<m) {
            if(stc.isEmpty() || M[stc.peek()]<=M[i]) {
                stc.push(i);
                i++;
            } else {
                top = stc.pop();
                if(stc.isEmpty()) {
                    area = M[top]*i;
                } else {
                    area = M[top]*(i-stc.peek()-1);
                }
                max = Math.max(area,max);
            }
        }
        
        while(!stc.isEmpty()){
            top = stc.pop();
            if(stc.isEmpty()) {
                area = M[top]*i;
            } else {
                area = M[top]*(i-stc.peek()-1);
            }
            max = Math.max(area,max);
        }
        
        return max;
    }
    
    public int maxHistogramArea(int M[], int m) {
    
        int left[] = new int[m];
        int right[] = new int[m];
        Arrays.fill(left,-1);
        Arrays.fill(right,m);
        
        Stack<Integer> stc = new Stack<>();
        
        for(int i=0; i<m; i++) {
            while(!stc.isEmpty() && M[stc.peek()]>=M[i]) {
                stc.pop();
            }
            if(stc.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stc.peek();
            }
            stc.push(i);
        }
        
        while(!stc.isEmpty()) {
            stc.pop();
        }
        
        for(int j=m-1; j>=0; j--) {
            while(!stc.isEmpty() && M[stc.peek()]>=M[j]) {
                stc.pop();
            }
            if(stc.isEmpty()) {
                right[j] = m;
            } else {
                right[j] = stc.peek();
            }
            stc.push(j);
        }
        
        int curr = 0;
        int max = 0;
        for(int i=0; i<m; i++) {
            
            curr = M[i]*(right[i]-left[i]-1);
            max = Math.max(curr,max);
        }
        return max;
         
    }
}
