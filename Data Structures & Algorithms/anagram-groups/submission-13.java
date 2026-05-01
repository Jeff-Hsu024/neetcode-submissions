class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var s : strs) {
            var charArray = s.toCharArray();
            Arrays.sort(charArray);
            var sorted = new String(charArray);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
