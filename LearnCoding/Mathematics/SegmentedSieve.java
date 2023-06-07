//Problem: https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1

import java.util.*;

class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        boolean prime[] = new boolean[N+1];
        Arrays.fill(prime,true);

        for(int p=2; p*p<=N; p++) {
            if(prime[p]) {
                for(int j=p*p; j<=N; j+=p) {
                    prime[j] = false;
                }
            }
        }

        ArrayList<Integer> primeList = new ArrayList();
        for(int i=2; i<=N; i++) {
            if(prime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    //Note: In this program we are considering higher level also as inclusive, in few programs on net higher level is not inclusive.
    //Time Complexity: O(nlog(logn)) Space Complexity: O(sqrt(N))
    static ArrayList<Integer> segmentedSieveOfEratosthenes(int N) {
        int limit = (int) Math.floor(Math.sqrt(N));
        ArrayList<Integer> primeList = sieveOfEratosthenes(limit);
        int low = limit+1;
        int high =  2*limit;
        boolean prime[] = new boolean[limit];
        while(low<=N) {
            if(high>N) {
                high = N;
            }
            Arrays.fill(prime,true);

            for(int primeDigit: primeList) {
                int lowLim = (int) Math.floor(low/primeDigit)*primeDigit;
                if(lowLim < low) {
                    lowLim += primeDigit;
                }
                for(;lowLim<=high; lowLim+=primeDigit) {
                    prime[lowLim-low] = false;
                }
            }

            for(int i=low; i<=high; i++) {
                
                if(prime[i-low]) {
                    primeList.add(i);
                }
            }

            low = low + limit;
            high = high + limit;
        }

        return primeList;

    }
    public static void main(String args[])
    {
        int n = 100;
        System.out.println("Primes upto " + n + ":");
        ArrayList<Integer> primeList = segmentedSieveOfEratosthenes(n);
        System.out.println(primeList);
    }
}