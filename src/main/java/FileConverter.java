import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

// task 2
public class FileConverter {
    public static void main(String[] args) {

        String fileName = "files/file2.txt";
        List<User> userList = readFile(fileName);
        writeToJsonFile(userList,"files/user.json");

    }

    public static List<User> readFile(String fileName) {

        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            // Читаємо заголовок
            String headerLine = reader.readLine();
            String [] headers = headerLine.split(" ");

            // Читаємо решту рядків та створюємо об'єкти User
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");

                User user = new User();
                for (int i = 0; i < headers.length; i++) {
                    switch (headers[i]) {
                        case "name":
                            user.setName(values[i]);
                            break;
                        case "age":
                            user.setAge(Integer.parseInt(values[i]));
                            break;
                    }
                }
                userList.add(user);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return userList;
    }

    private static void writeToJsonFile(List<User> userList, String jsonFileName) {

        try (FileWriter fileWriter = new FileWriter(jsonFileName)) {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(fileWriter, userList);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
