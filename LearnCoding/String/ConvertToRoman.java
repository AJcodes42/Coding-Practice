//Problem:  https://practice.geeksforgeeks.org/problems/convert-to-roman-no/1

class Solution
{
	String convertToRoman(int n) {
		
		String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String hundreds[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String thousands[] = {"","M","MM","MMM"};
		
		String result = "";
		
		result += thousands[n/1000];
		result += hundreds[(n%1000)/100];
		result += tens[(n%100)/10];
		result += ones[n%10];
		
		return result;
		
	}
}