//Problem: https://practice.geeksforgeeks.org/problems/implement-strstr/1

//Solution 1:
class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
       for(int i=0;i<s.length(); i++) {
           for(int j =0,m=i; j<x.length() && m<s.length();j++,m++) {
               if(s.charAt(m) != x.charAt(j)) {
                   break;
               }
               if(j == x.length()-1) {
                   return i;
               }
           }
       }
       return -1;
    }
}

//Solution 2: 
class GfG
{
    int strstr(String str, String target)
    {
        for(int i=0; i<=str.length()-target.length(); i++) {
            int j;
            for(j=0; j< target.length(); j++) {
                if(str.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }
            if(j == target.length()) {
                    return i;
            }
        }
        
        return -1;
    }
}


//Solution 3: KMP Pattern Matching Algorithm

class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
       int lps[] = new int[s.length()];
       lpsCreate(x,lps);
       int i= 0;
       int j=0;
       while(i<s.length()) {
           if(s.charAt(i) == x.charAt(j)) {
               i++;
               j++;
               if(j == x.length()) {
                    return i-x.length();
               }
           } else if(j>0) {
               j = lps[j-1];
           } else i++;
       }
       
       return -1;
    }
    
    public void lpsCreate(String s, int lps[]) {
        int i =1;
        int j = 0;
        
        while(i<s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] =j; 
                i++;
            } else if(j>0) {
              j = lps[j-1];  
            } else {
                i++;
            }
        }
    }
}