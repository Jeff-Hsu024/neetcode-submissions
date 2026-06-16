class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var str: strs) {
            var key = helper(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String helper(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
