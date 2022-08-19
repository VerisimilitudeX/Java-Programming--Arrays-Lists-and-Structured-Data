import java.util.Scanner;

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

    public void bruteForce(String encrypted) {
        for (int key = 0; key < 26; key++) {
            String decrypted = CaesarCipher.decrypt(encrypted);
            System.out.println(decrypted + " " + key);
        }
    }
}