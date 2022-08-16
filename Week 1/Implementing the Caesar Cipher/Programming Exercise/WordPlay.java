public class WordPlay {
    public static boolean isVowel(char ch) {
        if (Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i'
                || Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public static String replaceVowels(String phrase, char ch) {
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) {
                phrase = phrase.replace(phrase.charAt(i), ch);
            }
        }
        return phrase;
    }

    public static String emphasize(String phrase, char ch) {
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ch) {
                if (i % 2 == 0) {
                    phrase = phrase.replaceFirst(String.valueOf(ch), "*");
                } else if (i % 2 == 1) {
                    phrase = phrase.replaceFirst(String.valueOf(ch), "+");
                }
            }
        }
        return phrase;
    }

    public static void main(String[] args) {
        System.out.println(isVowel('a'));
        System.out.println(isVowel('F'));
        System.out.println("");
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println("");
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}