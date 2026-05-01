class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var sCharArray = s.toCharArray();
        var tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        for (int i = 0; i < tCharArray.length; i++) {
            var sChar = sCharArray[i];
            var tChar = tCharArray[i];
            if (sChar != tChar) {
                return false;
            }
        }

        return true;
    }
}
