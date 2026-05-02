class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // key, list
        Map<String, List<String>> map = new HashMap<>();

        for (var str: strs) {
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            var key = new String(charArray);

            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(str);
        }


        return new ArrayList<>(map.values());
        
    }
}
