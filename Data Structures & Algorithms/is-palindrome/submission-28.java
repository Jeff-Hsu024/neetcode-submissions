class Solution {
    public boolean isPalindrome(String s) {
        var formatted = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0;
        int r = formatted.length() - 1;

        var charArray = formatted.toCharArray();

        while (l < r) {
            var lc = charArray[l];
            var rc = charArray[r];

            if (lc != rc) {
                return false;
            }

            l = l + 1;
            r = r - 1;
        }

        return true;
    }
}
