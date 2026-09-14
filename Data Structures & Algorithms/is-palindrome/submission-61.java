class Solution {
    public boolean isPalindrome(String s) {
        var chars = s.toCharArray();
        var l = 0;
        var r = chars.length - 1;

        while (l < r) {
            while(!Character.isLetterOrDigit(chars[l]) && l < r) {
                l = l + 1;
            }
            while(!Character.isLetterOrDigit(chars[r]) && l < r) {
                r = r - 1;
            }
            var lc = Character.toLowerCase(chars[l]);
            var rc = Character.toLowerCase(chars[r]);
            if (lc != rc) {
                return false;
            }
            l = l + 1;
            r = r - 1;
        }

        return true;
    }
}
