import java.util.ArrayList;
import edu.duke.FileResource;

public class CharactersInPlay {
    private ArrayList<String> characters = new ArrayList<String>();
    private ArrayList<Integer> counts = new ArrayList<Integer>();

    private void update(String person) {
        if (characters.indexOf(person) != -1 && Character.isUpperCase(person.strip().charAt(1))) {
            int index = characters.indexOf(person);
            counts.set(index, counts.get(index) + 1);
        } else {
            characters.add(person);
            int index = characters.indexOf(person);
            counts.add(index, index + 1);
        }
    }

    private void findAllCharacters() {
        FileResource fr = new FileResource("Week 2/Telling A Random Story/ProgrammingRandomStoryData/likeit.txt");
        for (String line : fr.lines()) {
            if (line.indexOf(".") != -1) {
                int index = line.indexOf(".");
                String person = line.substring(0, index);
                update(person);
                index = 0;
                person = "";
            }
        }
    }

    private void charactersWithNumParts(int num1, int num2) {
        for (String person : characters) {
            if (counts.get(characters.indexOf(person)) >= num1 && counts.get(characters.indexOf(person)) <= num2 && person.length() < 25) {
                System.out.println(person + "\t" + counts.get(characters.indexOf(person)));
            }
        }
    }

    public void tester() {
        findAllCharacters();
        for (String ch : characters) {
            if (ch.length() < 25) {
                System.out.println(ch + "\t" + counts.get(characters.indexOf(ch)));
            }
        }
        System.out.println("----------------------------------------");
        charactersWithNumParts(10, 15);
    }
}
