class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        var length = str.length();
        var charArray = str.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            var leftChar = charArray[i];
            var rightChar = charArray[length - i - 1];
            if (leftChar != rightChar) {
                return false;
            }
        }
        return true;
    }
}
