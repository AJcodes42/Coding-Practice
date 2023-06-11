//Problem: https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    ArrayList<Integer> search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        int lps[] = new int[M];
        Arrays.fill(lps, 0);

        lps(lps,pat);
        int len = 0,i=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<N) {
            if(txt.charAt(i) == pat.charAt(len)) {
                len++;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len-1];
                } else {
                    i++;
                }
            }
            if(len == M) {
                ans.add(i-M+1);
                len = lps[len-1];
            }

        }
        return ans;


    }

    void lps(int lps[], String pat) {
        int M = pat.length();
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i<M) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if(len != 0){
                len = lps[len-1];
            } else {
                lps[i] = len;
                i++;
            }
        }
    }
}
