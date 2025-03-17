import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        
        // Read the File

        String filePath = "E:\\Java Projects\\test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            
            String line;
            while ((line = reader.readLine()) != null){ 
                System.out.println(line);
            }
        }

        catch(FileNotFoundException e) {
            System.out.println("Could not find the file");
        }

        catch(IOException e) {
            System.out.println("Something went wrong");
        }

    }
}