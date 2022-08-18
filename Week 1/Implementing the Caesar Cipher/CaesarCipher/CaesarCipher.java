public class CaesarCipher {
    public static String encrypt(String input, int key) {
        char[] charInput = input.toCharArray();
        String encrypted = "";
        for (char ch : charInput) {
            int ASCII = (int) ch;
            ASCII += key;
            if (!Character.isAlphabetic(ch)) {
                ;
                encrypted += Character.toString(ch);
                continue;
            } else if (ASCII > 90) {
                ASCII -= 90;
                if (Character.isUpperCase(ch)) {
                    ASCII += 64;
                } else if (Character.isLowerCase(ch)) {
                    ASCII += 96;
                }
            }
            ch = (char) ASCII;
            encrypted += Character.toString(ch);
        }
        return encrypted;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
    }
}