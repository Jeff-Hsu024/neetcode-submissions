class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        var chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l<r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
