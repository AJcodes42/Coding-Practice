//Problem: https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    String content = br.readLine().trim();
		    String elements[] = content.split(" ");
		    for(int i=0; i<n; i++) {
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    ArrayList<Integer> ans = sortByFrequency(arr,n);
		    
		    for(Integer a : ans) {
		        System.out.print(a+" ");
		    }
		    System.out.println();
		    
		    
		}
	}
	
	static ArrayList<Integer> sortByFrequency(int arr[], int n) {
	    
	    HashMap<Integer,Integer> hmap = new HashMap<>();
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    for(int i=0; i<n; i++) {
	        if(hmap.containsKey(arr[i])) {
	            hmap.put(arr[i],hmap.get(arr[i])+1);
	        } else {
	            hmap.put(arr[i],1);
	        }
	        
	        list.add(arr[i]);
	    }
	    
	    
	    Collections.sort(list,new Comparator<Integer>(){
	        public int compare(Integer a, Integer b) {
	            int val = hmap.get(b).compareTo(hmap.get(a));
	            if(val != 0) {
	                return val;
	            } else {
	                return a.compareTo(b);
	            }
	        }
	    });
	   
	    
	    return list;
	    
	}
}
