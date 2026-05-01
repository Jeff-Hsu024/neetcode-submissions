class Solution {
    public boolean isPalindrome(String s) {
        var foramtted = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        var charArray = foramtted.toCharArray();

        int l = 0;
        int r = charArray.length - 1;

        while (l < r) {
            var lc = charArray[l];
            var rc = charArray[r];
            if(lc != rc) {
                return false;
            }
            l = l + 1;
            r = r - 1;
        }

        return true;
    }
}
