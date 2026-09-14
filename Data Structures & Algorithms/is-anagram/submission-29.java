class Solution {
    public boolean isAnagram(String s, String t) {
        var sortedS = helper(s);
        var sortedT = helper(t);
        return sortedS.equals(sortedT);
    }

    public String helper(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
