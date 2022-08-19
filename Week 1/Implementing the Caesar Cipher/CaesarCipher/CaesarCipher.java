public class CaesarCipher {
    private String encrypted;
    private String decrypted;
    private int key;

    public CaesarCipher(int key) {
        this.key = key;
        encrypted = "";
        decrypted = "";
    }

    public String encrypt(String input) {
        char[] charInput = input.toCharArray();
        for (char ch : charInput) {
            int ASCII = (int) ch;
            ASCII += key;
            if (!Character.isAlphabetic(ch)) {
                encrypted += Character.toString(ch);
                continue;
            } else if (ASCII > 90 && Character.isUpperCase(ch)) {
                ASCII -= 26;
            } else if (ASCII > 122 && Character.isLowerCase(ch)) {
                ASCII -= 26;
            }
            ch = (char) ASCII;
            encrypted += Character.toString(ch);
        }
        return encrypted;
    }

    public String decrypt(String encrypted) {
        char[] charInput = encrypted.toCharArray();
        for (char ch : charInput) {
            int ASCII = (int) ch;
            ASCII -= key;
            if (!Character.isAlphabetic(ch)) {
                decrypted += Character.toString(ch);
                continue;
            } else if (ASCII < 90 && Character.isUpperCase(ch) && (ASCII + 26) <= 90) {
                ASCII += 26;
            } else if (ASCII < 122 && Character.isLowerCase(ch) && (ASCII + 26) <= 122) {
                ASCII += 26;
            }
            ch = (char) ASCII;
            decrypted += Character.toString(ch);
        }
        return decrypted;
    }

    public int countLetters(String input) {
        int[] alphaCount = new int[26];
        String alphabet = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
        for (char ch : input.toCharArray()) {
            int index = alphabet.indexOf(Character.toLowerCase(ch));
            if (index != -1) {
                alphaCount[index]++;
            }
        }
        int maxIndex = 0;
        for (int index : alphaCount) {
            if (index > maxIndex) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    public void bruteForce(String encrypted) {
        for (int key = 0; key < 26; key++) {
            CaesarCipher cc = new CaesarCipher(key);
            String decrypted = cc.decrypt(encrypted);
            System.out.println(decrypted + " " + key);
        }
    }
}