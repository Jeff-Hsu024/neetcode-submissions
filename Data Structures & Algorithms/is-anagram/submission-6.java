class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
