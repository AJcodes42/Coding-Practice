//Problem: https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1

class Solution{

    //Time Complexity: O(nlog(logn)) Space Complexity: O(N)
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
}