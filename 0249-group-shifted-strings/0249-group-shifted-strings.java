class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char first = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                int offset = curr - first;
                if (offset < 0)
                    offset += 26;
                sb.append(Integer.toString(offset));
                sb.append(' ');
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<String>());
            }
            map.get(sb.toString()).add(s);
        }
        List<List<String>> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            answer.add(map.get(key));
        }
        return answer;
    }
}