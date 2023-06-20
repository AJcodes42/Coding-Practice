//Problem: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

class GfG
{
    int maxLen(int arr[], int n)
    {
        int sum[] = new int[n];
        Arrays.fill(sum,0);
        sum[0] = arr[0];
        for(int i=1; i<n; i++) {
            sum[i] = arr[i] + sum[i-1];
        }
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int maxAns = 0,temp;
        
        for(int i=0; i<n; i++) {
            if(sum[i] == 0) {
                maxAns = Math.max(i+1,maxAns);
            } else if(hmap.containsKey(sum[i])) {
                temp = i-hmap.get(sum[i]);
                maxAns = Math.max(temp,maxAns);
            } else {
                hmap.put(sum[i],i);
            }
        }
        
        return maxAns;
    }
}


// Same implementation in less lines with using sum array
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Long,Integer> hmap = new HashMap<>();
        int resLen = 0;
        long sum = 0L;
        hmap.put(0L,-1);
        for(int i=0; i<n; i++) {
            sum +=arr[i];
            if(hmap.containsKey(sum)) {
                int j = hmap.get(sum);
                if(resLen<i-j) {
                    resLen = i-j;
                }
            } else {
                hmap.put(sum,i);
            }
        }
        
        return resLen;
    }
}
