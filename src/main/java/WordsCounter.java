import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// task 3
public class WordsCounter {
    public static void main(String[] args) {

        String fileName = "files/words.txt";
        displayWords(countWords(fileName));

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

    public static void displayWords(Map<String, Integer> wordsList) {
        for (Map.Entry<String, Integer> entry : wordsList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
