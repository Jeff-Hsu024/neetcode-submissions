class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return helper(s).equals(helper(t));
    }
    Map<Character, Integer> helper(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
