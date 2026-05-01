class Solution {
    private final String prefix = "#sadqwdw__";
    private final String split = "////____";

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (var str : strs) {
            sb.append(str.length()).append(prefix).append(str).append(split);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        var parts = str.split(split);
        List<String> res = new ArrayList<>();
        for (var part : parts) {
            var len = Integer.parseInt(part.split(prefix)[0]);
            if (len == 0) {
                res.add("");
            } else {
                var stro = part.split(prefix)[1];
                res.add(stro);
            }
        }

        return res;
    }
}
