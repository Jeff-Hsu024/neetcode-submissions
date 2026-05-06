class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return count(s).equals(count(t));
    }

    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (var c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
