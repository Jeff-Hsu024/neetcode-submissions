class Solution {
    public boolean isPalindrome(String s) {
        var format = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int l = 0;
        int r = format.length() - 1;
        var array = format.toCharArray();

        while (l < r) {
            if (array[l] != array[r]) {
                return false;
            }
            l = l + 1;
            r = r - 1;
        }
        return true;
    }
}
