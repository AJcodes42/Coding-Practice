//Problem: https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Solution explanation: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count_of_all_subarrays_with_zero_sum/topic
        long count = 0L; long sum = 0L;
        
        HashMap<Long,Integer> hmap = new HashMap<>();
        hmap.put(0L,1);
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(hmap.containsKey(sum)) {
                count += hmap.get(sum);
                hmap.put(sum,hmap.get(sum)+1);
            } else hmap.put(sum,1);
        }
        
        return count;
    }
}
