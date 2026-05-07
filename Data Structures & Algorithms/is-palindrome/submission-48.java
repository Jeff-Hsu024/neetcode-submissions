class Solution {
    public boolean isPalindrome(String s) {
        var chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(chars[r])) {
                r--;
            }

            var lc = Character.toLowerCase(chars[l]);
            var rc = Character.toLowerCase(chars[r]);
            if (lc != rc) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
