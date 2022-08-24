import java.util.ArrayList;
import java.util.HashMap;
import edu.duke.FileResource;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> words;

    public WordsInFiles() {
        words = new HashMap<String, ArrayList<String>>();
    }

    private void addWordsFromFile(File f) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get(f.getPath())));
            String[] words = contents.split("[^A-Za-z]+");
            for (String word : words) {
                if (this.words.containsKey(word)) {
                    this.words.get(word).add(f.getName());
                } else {
                    ArrayList<String> files = new ArrayList<String>();
                    files.add(f.getName());
                    this.words.put(word, files);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + f.getName());
        }
    }

    public void buildWordFileMap() {
        words.clear();

    }
}