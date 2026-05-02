class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        var ary = s.toCharArray();
        Arrays.sort(ary);
        return new String(ary);
    }
}
