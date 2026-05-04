class Solution {
    public boolean isPalindrome(String s) {
        var chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            var lc = chars[l];
            while (l < r && !Character.isLetterOrDigit(lc)) {
                l = l + 1;
                lc = chars[l];
            }

            var rc = chars[r];
            while (l < r && !Character.isLetterOrDigit(rc)) {
                r = r - 1;
                rc = chars[r];
            }

            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }
            l = l + 1;
            r = r - 1;
        }

        return true;
    }
}
