//Problem: https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1

class Solution {

    public boolean isValid(String s) {
        
        String[] nums = s.split("\\.");
        try {
            if(nums.length != 4) {
                return false;
            }
            if(s.charAt(s.length()-1) == '.') {
                return false;
            }
            for(int i=0; i<4; i++) {
                if(nums[i].length() == 0 || (nums[i].length()>1 && nums[i].charAt(0) == '0')) {
                    return false;
                }
                if(Integer.parseInt(nums[i])<0 || Integer.parseInt(nums[i])>255) {
                    return false;
                }
            }
        }catch(NumberFormatException e) {
            return false;
        }
        
        return true;
    }
}