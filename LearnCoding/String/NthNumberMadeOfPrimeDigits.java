//Problem: https://practice.geeksforgeeks.org/problems/nth-number-made-of-prime-digits4319/1

class Solution
{
    //Function to find nth number made of only prime digits.
    public static int primeDigits(int n)
    {
        int prime[] = {7,2,3,5};
        StringBuilder sb = new StringBuilder("");
        while(n>0) {
            sb.append(prime[n%4]);
            if(n%4 == 0) {
                n /=4;
                n--;
            } else {
                n/=4;
            }
        }

        String s = sb.reverse().toString();
        return Integer.parseInt(s); // instead of parse int and string builder directly we can take the value in int variable by multiplying with 10 each digit
    }
}