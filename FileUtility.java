import java.io.*;
import java.nio.file.*;

public class FileUtility {
    public static void writeFile(String filePath, String content){
        System.out.println("Writing to file: "+ filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
            System.out.println("Write successful.");
        } catch(IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readFile(String filePath) {
        System.out.println("Reading file: " +  filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))  {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void modifyFile(String filePath, String oldWord, String newWord) {
        System.out.println("Modify file: " + filePath);
        try {
            Path path = Paths.get(filePath);
            String  content = new String (Files.readAllBytes(path));
            content = content.replaceAll(oldWord, newWord);
            Files.write(path, content.getBytes());
            System.out.println("Modification successful.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "simple.txt";

        writeFile(filePath, "Hello World!\nWelcome to Java File Handling.");
        readFile(filePath);
        modifyFile(filePath, "World", "Intern");
        readFile(filePath);
    }
}