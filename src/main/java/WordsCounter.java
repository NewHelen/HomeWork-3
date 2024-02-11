import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// task 3
public class WordsCounter {
    public static void main(String[] args) {

        String fileName = "files/words.txt";
        Map<String, Integer> unsortedEntries = countWords(fileName);
        List<Map.Entry<String, Integer>> sortedEntries = entriesSortedByValues(unsortedEntries);
        displayWords(sortedEntries);

    }

    public static Map<String, Integer> countWords(String fileName) {

        Map<String, Integer> wordsList = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length; i++) {
                    wordsList.put(words[i], wordsList.getOrDefault(words[i], 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordsList;
    }

    public static <K,V extends Comparable<? super V>> List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Map.Entry<K,V>>() {
                    @Override
                    public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }

    public static void displayWords(List<Map.Entry<String, Integer>> sortedEntries) {
              for (Map.Entry<String, Integer> entry : sortedEntries) {

            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
