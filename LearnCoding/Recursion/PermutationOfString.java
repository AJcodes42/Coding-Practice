//Problem: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

class Solution {
    public List<String> find_permutation(String S) {
        
        int index = 0;
        ArrayList<String> list = new ArrayList<>();
        permutationUtil(S,index,list);
        
        Collections.sort(list);
        return list;
    }

    public void permutationUtil(String S, int index, ArrayList<String> list) {
        if(index == S.length()-1) {
            list.add(S);
            return;
        }
        
        for(int i=index; i<S.length(); i++) {
            S = swap(S,i,index);
            permutationUtil(S,index+1,list);
            S = swap(S,i,index);
        }
    }
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
