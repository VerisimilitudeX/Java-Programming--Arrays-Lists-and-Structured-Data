import resources.*;

public class WordLengths {
    public static void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            if (word.length() > 0) {
                counts[word.length() - 1]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("There are " + counts[i] + " words of length " + (i + 1) + ".");
        }
    }

    public static void main(String[] args) {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
    }
}