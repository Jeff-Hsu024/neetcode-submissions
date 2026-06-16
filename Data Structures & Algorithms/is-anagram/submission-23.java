class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return countMap(s).equals(countMap(t));
    }

    Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
