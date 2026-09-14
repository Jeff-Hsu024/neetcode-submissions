class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var s:strs) {
            var key = helper(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return map.values().stream().toList();
    }

    String helper(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
