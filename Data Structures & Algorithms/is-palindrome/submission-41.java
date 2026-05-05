class Solution {
    public boolean isPalindrome(String s) {
        var format = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int l = 0;
        int r = format.length() - 1;
        var chars = format.toCharArray();
        while( l < r ) {
            var lc = chars[l];
            var rc = chars[r];
            if (lc != rc) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
