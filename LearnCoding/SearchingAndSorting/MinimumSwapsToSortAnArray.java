//Problem: https://practice.geeksforgeeks.org/problems/minimum-swaps/1

import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
    static class Pair{
        int key;
        int value;
        Pair(int a, int b) {
            key = a;
            value = b;
        }
        int getKey() {
            return key;
        }
        int getValue() {
            return value;
        }
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int ans = 0;
        ArrayList<Pair> list = new ArrayList<>();
        Pair p;
        for(int i=0; i<nums.length; i++) {
            p = new Pair(nums[i], i);
            list.add(p);
        }

        Collections.sort(list, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                if(p1.getKey()<p2.getKey()) {
                    return -1;
                } else if(p1.getKey()>p2.getKey()) {
                    return 1;
                } else return 0;
            }
            
        });

        int cyclesize = 0;
        boolean visited[] = new boolean[nums.length];
        Arrays.fill(visited,false);

        for(int i=0; i<nums.length; i++) {

            if(visited[i] || list.get(i).getValue() == i) {
                continue;
            }

            cyclesize = 0;

            while(!visited[i]) {
                visited[i] = true;
                i = list.get(i).getValue();
                cyclesize++;
            }

            if(cyclesize>0) {
                ans = ans +cyclesize-1;
            }
        }

        return ans;
    }
}
