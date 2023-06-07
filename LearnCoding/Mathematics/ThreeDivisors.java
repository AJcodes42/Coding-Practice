//Problem: https://practice.geeksforgeeks.org/problems/3-divisors3942/1

// 1st Solution uses Sieve of eratosthenes and is more optimised. single query TimeComplexity:O(N^(1/2)log(logN^(1/2))) SpaceComplexity: O(N^(1/2))
class Solution1{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> ansList = new ArrayList<>();
        Long max = findMaxQ(query);
        int primeLimit = (int)Math.sqrt(max);
        ArrayList<Integer> primeList = sieveOfEratosthenes(primeLimit);
        for(Long qu: query) {
            threeDivisorUtil(qu, ansList, primeList);
        }
        
        return ansList;
    }
    
    static void threeDivisorUtil(Long q, ArrayList<Integer> ansList, ArrayList<Integer> primeList) {
        int ans = 0;
        
        // for(int prime : primeList) {
            
        //     if((long)prime*prime<=q) {
        //         ans++;
        //     }
        // }
        
        //Optimisation with binary search
        int qsqrt = (int)Math.sqrt(q);
        int lo=0,hi=primeList.size()-1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(primeList.get(mid)<=qsqrt) {
                lo=mid+1;
                ans = Math.max(ans,mid+1);
            } else {
                hi=mid-1;
            }
        }
        
        ansList.add(ans);
    }
    
    static Long findMaxQ(ArrayList<Long> query) {
        Long max = 0L;
        for(Long q :  query) {
            max = Math.max(max,q);
        }
        return max;
    }
    
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



//Solution2 uses general prime check.Single query TimeComplexity: O(N^(1/2) * N^(1/4))  Space Complexity: O(1)

class Solution2{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> ansList = new ArrayList<>();
    
        for(Long qu: query) {
            threeDivisorUtil(qu, ansList);
        }
        
        return ansList;
    }
    
    static void threeDivisorUtil(Long q, ArrayList<Integer> ansList) {
        int ans = 0;
        
        for(long i=2; i*i<=q; i++) { // have i as long otherwise i*i can go out of range of int and misbehave
            if(isPrime(i)) {
                ans++;
            }
        }
        ansList.add(ans);
    }
    
    static boolean isPrime(long val) {
        for(long j=2; j*j<=val; j++) {
            if(val%j == 0) {
                return false;
            } 
        }
        return true;
    }
    

}
