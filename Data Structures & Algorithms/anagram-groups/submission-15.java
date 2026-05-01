class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var str : strs) {
            var charAry = str.toCharArray();
            Arrays.sort(charAry);
            var sorted = new String(charAry);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
