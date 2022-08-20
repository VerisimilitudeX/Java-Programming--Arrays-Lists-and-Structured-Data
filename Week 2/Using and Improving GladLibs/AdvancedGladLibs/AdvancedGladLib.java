import edu.duke.*;
import java.util.*;

public class AdvancedGladLib {
	private ArrayList<String> adjectiveList;
	private ArrayList<String> nounList;
	private ArrayList<String> colorList;
	private ArrayList<String> countryList;
	private ArrayList<String> nameList;
	private ArrayList<String> animalList;
	private ArrayList<String> timeList;
	private ArrayList<String> verbList;
	private ArrayList<String> fruitList;
	private ArrayList<String> wordsSeen;
	private HashMap<String, ArrayList<String>> myMap;

	private Random myRandom;

	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/datalong";
	private static String dataSourceDirectory = "datalong";

	public AdvancedGladLib() {
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
		wordsSeen = new ArrayList<String>();
		myMap.put("adjective", adjectiveList);
		myMap.put("noun", nounList);
		myMap.put("color", colorList);
		myMap.put("country", countryList);
		myMap.put("name", nameList);
		myMap.put("animal", animalList);
		myMap.put("time", timeList);
		myMap.put("verb", verbList);
		myMap.put("fruit", fruitList);
	}

	public AdvancedGladLib(String source) {
		initializeFromSource(source);
		myRandom = new Random();
		wordsSeen = new ArrayList<String>();
		myMap.put("adjective", adjectiveList);
		myMap.put("noun", nounList);
		myMap.put("color", colorList);
		myMap.put("country", countryList);
		myMap.put("name", nameList);
		myMap.put("animal", animalList);
		myMap.put("time", timeList);
		myMap.put("verb", verbList);
		myMap.put("fruit", fruitList);

	}

	private void initializeFromSource(String source) {
		String[] categories = { "adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit" };
		for (String category : categories) {
			myMap.put(category, readIt(source + "/" + category + ".txt"));
		}
	}

	private String randomFrom(ArrayList<String> source) {
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}

	private String getSubstitute(String label) {
		if (label.equals("country")) {
			String randCountry = randomFrom(countryList);
			if (wordsSeen.indexOf(randCountry) == -1) {
				return randCountry;
			} else {
				return randomFrom(countryList);
			}
		} else if (label.equals("name")) {
			String randName = randomFrom(nameList);
			if (wordsSeen.indexOf(randName) == -1) {
				return randName;
			} else {
				return randomFrom(nameList);
			}
		} else if (label.equals("animal")) {
			String randAnimal = randomFrom(animalList);
			if (wordsSeen.indexOf(randAnimal) == -1) {
				return randAnimal;
			} else {
				return randomFrom(animalList);
			}
		} else if (label.equals("timeframe")) {
			String randTime = randomFrom(timeList);
			if (wordsSeen.indexOf(randTime) == -1) {
				return randTime;
			} else {
				return randomFrom(timeList);
			}
		} else if (label.equals("verb")) {
			String randVerb = randomFrom(verbList);
			if (wordsSeen.indexOf(randVerb) == -1) {
				return randVerb;
			} else {
				return randomFrom(verbList);
			}
		} else if (label.equals("fruit")) {
			String randFruit = randomFrom(fruitList);
			if (wordsSeen.indexOf(randFruit) == -1) {
				return randFruit;
			} else {
				return randomFrom(fruitList);
			}
		} else if (label.equals("color")) {
			String randColor = randomFrom(colorList);
			if (wordsSeen.indexOf(randColor) == -1) {
				return randColor;
			} else {
				return randomFrom(colorList);
			}
		} else if (label.equals("noun")) {
			String randNoun = randomFrom(nounList);
			if (wordsSeen.indexOf(randNoun) == -1) {
				return randNoun;
			} else {
				return randomFrom(nounList);
			}
		} else if (label.equals("adjective")) {
			String randAdjective = randomFrom(adjectiveList);
			if (wordsSeen.indexOf(randAdjective) == -1) {
				return randAdjective;
			} else {
				return randomFrom(adjectiveList);
			}
		} else if (label.equals("number")) {
			return Integer.toString(myRandom.nextInt(100));
		} else {
			return "**UNKNOWN**";
		}
	}

	private String processWord(String w) {
		int first = w.indexOf("<");
		int last = w.indexOf(">", first);
		if (first == -1 || last == -1) {
			return w;
		}
		String prefix = w.substring(0, first);
		String suffix = w.substring(last + 1);
		String sub = getSubstitute(w.substring(first + 1, last));
		return prefix + sub + suffix;
	}

	private void printOut(String s, int lineWidth) {
		int charsWritten = 0;
		for (String w : s.split("\\s+")) {
			if (charsWritten + w.length() > lineWidth) {
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w + " ");
			charsWritten += w.length() + 1;
		}
	}

	private String fromTemplate(String source) {
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}

	private ArrayList<String> readIt(String source) {
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(dataSourceURL + source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		}
		return list;
	}

	public void makeStory() {
		System.out.println("\n");
		String story = fromTemplate("datalong/madtemplate2.txt");
		printOut(story, 60);
		wordsSeen.clear();
	}

}
