class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> smap = new HashMap<>();
        for (var c : s.toCharArray()) {
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (var c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        return smap.equals(tmap);
    }
}
