class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretMap = new HashMap<>();
        for (char c : secret.toCharArray()) {
            if (!secretMap.containsKey(c)) {
                secretMap.put(c, 1);
            } else {
                secretMap.put(c, secretMap.get(c)+1);
            }
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            if (secretMap.containsKey(g)) {
                if (g == secret.charAt(i)) {
                    bull++;
                    if (secretMap.get(g) <= 0)
                        cow--;
                } else {
                    if (secretMap.get(g) > 0)
                        cow++;
                }
                secretMap.put(g, secretMap.get(g)-1);
            }
        }
        
        return bull + "A" + cow + "B";
    }
}