//Problem: https://practice.geeksforgeeks.org/problems/multiply-two-strings/1

class Solution
{
    //Time Complexity: O(m*n) SpaceComplexity: O(m+n)
    public String multiplyStrings(String s1,String s2)
    {
        int num = 0;
        if(s1.charAt(0) == '-' && s2.charAt(0) != '-') {
            num = -1;
            s1 = s1.substring(1);
        }
        if(s1.charAt(0) != '-' && s2.charAt(0) == '-') {
            num = -1;
            s2 = s2.substring(1);
        }
        
        if(s1.charAt(0) == '-' && s2.charAt(0) == '-') {
            s1 = s1.substring(1);
            s2 = s2.substring(1);
        }
        
        int totalLength = s1.length()+s2.length();
        
        int multiplication[] = new int[totalLength];
        Arrays.fill(multiplication,0);
        int s1Digit,s2Digit,carry,mul;
        String ans = "";
        for(int s1Index = s1.length()-1;s1Index>=0; s1Index--) {
            s1Digit = s1.charAt(s1Index) - '0';
            for(int s2Index = s2.length()-1;s2Index>=0; s2Index--) {
                s2Digit = s2.charAt(s2Index) - '0';
                mul = s1Digit*s2Digit + multiplication[s1Index+s2Index+1];
                multiplication[s1Index+s2Index+1] = mul%10;
                multiplication[s1Index+s2Index] += mul/10;
            
            }
            
        }
        
        StringBuffer sb = new StringBuffer();
        boolean firstTime = true;
        for(int value : multiplication) {
            if(sb.length() != 0 || value !=0) {
                if(firstTime && num<0) {
                    sb.append("-");
                    firstTime = false;
                }
                sb.append(value);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();    }
}
