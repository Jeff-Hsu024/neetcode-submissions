class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // group
        // key -> list
        Map<String, List<String>> group = new HashMap<>();

        for (var str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            var key = new String(chars);
            group.putIfAbsent(key, new ArrayList());
            group.get(key).add(str);
        }

        return new ArrayList(group.values());
    }
}
