public class AdvancedCaesarCipher {
    public static String encrypt(String input, int key) {
        char[] charInput = input.toCharArray();
        String encrypted = "";
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

    public static String decrypt(String encrypted, int key) {
        char[] charInput = encrypted.toCharArray();
        String decrypted = "";
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

    public static String encryptTwoKeys(String input, int key1, int key2) {
        String encryptedTwoKeys = "";
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char ch = input.charAt(i);
                encryptedTwoKeys += encrypt(Character.toString(ch), key1);
            } else if (i % 2 == 1) {
                char ch = input.charAt(i);
                encryptedTwoKeys += encrypt(Character.toString(ch), key2);
            }
        }
        return encryptedTwoKeys;
    }

    public static String decryptTwoKeys(String encrypted, int key1, int key2) {
        String decryptedTwoKeys = "";
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % 2 == 0) {
                char ch = encrypted.charAt(i);
                decryptedTwoKeys += decrypt(Character.toString(ch), key1);
            } else if (i % 2 == 1) {
                char ch = encrypted.charAt(i);
                decryptedTwoKeys += decrypt(Character.toString(ch), key2);
            }
        }
        return decryptedTwoKeys;
    }

    public static void bruteForce(String encrypted) {
        // brute force the encrypted string
        for (int key1 = 0; key1 < 26; key1++) {
            for (int key2 = 0; key2 < 26; key2++) {
                String decrypted = decryptTwoKeys(encrypted, key1, key2);
                System.out.println(decrypted + " " + key1 + " " + key2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Hello", 5));
        System.out.println(decrypt("Mjqqt", 5));
        System.out.println(encryptTwoKeys("Hello", 0, 0));
        System.out.println(decryptTwoKeys("", 4, 17));
        bruteForce("");
    }
}