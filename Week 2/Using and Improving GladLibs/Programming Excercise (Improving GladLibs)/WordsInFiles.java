import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import edu.duke.FileResource;
import edu.duke.DirectoryResource;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> words;

    public WordsInFiles() {
        words = new HashMap<String, ArrayList<String>>();
    }

    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        for (String word : fr.words()) {
            if (words.containsKey(word)) {
                words.get(word).add(f.getName());
            } else {
                ArrayList<String> files = new ArrayList<String>();
                files.add(f.getName());
                words.put(word, files);
            }
        }
    }

    public void buildWordFileMap() {
        words.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }

    public int maxNumber() {
        int max = 0;
        for (String word : words.keySet()) {
            if (words.get(word).size() > max) {
                max = words.get(word).size();
            }
        }
        return max;
    }

    public void printFilesIn(String word) {
        ArrayList<String> files = words.get(word);
        if (files != null) {
            System.out.println(word + " appears in the following files:");
            for (String file : files) {
                System.out.println("\t" + file);
            }
        } else {
            System.out.println("No files found containing " + word);
        }
    }

    public void tester() {
        buildWordFileMap();
        System.out.println("max number of files is " + maxNumber());
        printFilesIn("tree");
    }
}