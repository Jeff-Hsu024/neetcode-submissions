class Solution {
    public boolean isAnagram(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        char[] charAry = s.toCharArray();
        Arrays.sort(charAry);
        return new String(charAry);
    }
}
