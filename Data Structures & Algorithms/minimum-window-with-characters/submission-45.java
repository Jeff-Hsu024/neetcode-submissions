class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (var c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int need = t.length();

        Map<Character, Integer> win = new HashMap<>();
        int collect = 0;

        var chars = s.toCharArray();
        int l = 0;

        int[] res = new int[] {-1, -1};
        int min = s.length() + 1;

        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            win.put(c, win.getOrDefault(c, 0) + 1);
            if (tmap.containsKey(c) && tmap.get(c) >= win.get(c)) {
                collect++;
            }

            // collect all t characters, reduce l to find min len.
            while (need == collect) {
                int len = r - l + 1;
                if (len < min) {
                    min = len;
                    res[0] = l;
                    res[1] = r;
                }
                var oc = chars[l];
                if (tmap.containsKey(oc) && tmap.get(oc) >= win.get(oc)) {
                    collect--;
                }
                win.put(oc, win.get(oc) - 1);
                l = l + 1;
            }

        }

        if (res[0] == -1) {
            return "";
        }

        return s.substring(res[0], res[1] + 1);
    }
}
