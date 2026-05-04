class Solution {
    public boolean isPalindrome(String s) {
        var chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                l = l + 1;
            }

            while (l < r && !Character.isLetterOrDigit(chars[r])) {
                r = r - 1;
            }

            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) {
                return false;
            }

            l = l + 1;
            r = r - 1;
        }

        return true;
    }
}
