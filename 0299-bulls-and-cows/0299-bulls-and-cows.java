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
        boolean[] checkList = new boolean[guess.length()];
        for (int i = 0; i < guess.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bull++;
                checkList[i] = true;
                if (secretMap.get(s) == 1) {
                    secretMap.remove(s);
                } else {
                    secretMap.put(s, secretMap.get(s)-1);
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (!checkList[i]) {
                char g = guess.charAt(i);
                if (secretMap.containsKey(g)) {
                    cow++;
                    if (secretMap.get(g) == 1) {
                        secretMap.remove(g);
                    } else {
                        secretMap.put(g, secretMap.get(g)-1);
                    }
                }
            }
            
        }
        return bull + "A" + cow + "B";
    }
}