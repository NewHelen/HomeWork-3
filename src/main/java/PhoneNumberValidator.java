import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

// task 1
public class PhoneNumberValidator {
    public static void main(String[] args) {

        String fileName = "files/file.txt";
        validatePhoneNumbers(fileName);
    }

    public static void validatePhoneNumbers(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s?\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})");

            while ((line = reader.readLine()) != null) {

                if (pattern.matcher(line).matches()) {

                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
