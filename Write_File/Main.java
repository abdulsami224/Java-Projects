
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        

        // Write in file

        String filePath = "E:\\Java Projects\\test.txt";
        String textContent = """
                I study Java programming
                JavaScript also
                and Python
                """;

        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(textContent);
            System.out.println("File written successfully");
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(IOException e) {
            System.out.println("Could not write file");
        }
    }
}