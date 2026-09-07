class Solution {
    public boolean isAnagram(String s, String t) {
        return helper(s).equals(helper(t));
    }

    String helper(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
